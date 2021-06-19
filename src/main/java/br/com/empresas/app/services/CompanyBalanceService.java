package br.com.empresas.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.empresas.data.entities.dto.CompanyRequest;
import br.com.empresas.data.entities.model.Company;
import br.com.empresas.data.repositories.CompanyRepository;
import br.com.empresas.data.repositories.CompanySpecification;
import br.com.empresas.infra.exceptions.NotFoundException;

@Service
public class CompanyBalanceService {
    @Autowired
	private CompanyRepository repository;
	
	public Double read(CompanyRequest dto) {
		Company company = new Company();
		company.setName(dto.getName());
		company.setId(dto.getId());
		
		Specification<Company> spec = new CompanySpecification(company);
		
		company =  repository
				       .findOne(spec)
				       .orElseThrow(() -> new NotFoundException("Company not found"));
		
		return company.getBalance();
	}
  
}
