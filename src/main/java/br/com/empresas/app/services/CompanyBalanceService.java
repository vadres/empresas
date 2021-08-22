package br.com.empresas.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.empresas.data.entities.dto.CompanyRequest;
import br.com.empresas.data.entities.model.Company;
import br.com.empresas.data.repositories.CompanyRepository;
import br.com.empresas.infra.exceptions.NotFoundException;

@Service
public class CompanyBalanceService {
    @Autowired
	private CompanyRepository repository;
	
	public Double read(CompanyRequest dto) {
		Company company = new Company();
		company.setName(dto.getName());
		company.setId(dto.getId());
		
		company =  repository
				       .findOne(Example.of(company))
				       .orElseThrow(() -> new NotFoundException("Company not found"));
		
		return company.getBalance();
	}
  
}
