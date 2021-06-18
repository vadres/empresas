package br.com.empresas.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.empresas.data.contracts.CrudModelService;
import br.com.empresas.data.entities.dto.CompanyRequest;
import br.com.empresas.data.entities.model.Company;
import br.com.empresas.data.repositories.CompanyRepository;
import br.com.empresas.data.repositories.CompanySpecification;
import br.com.empresas.infra.exceptions.NotFoundException;

@Service
public class CompanyService implements CrudModelService<CompanyRequest> {
    @Autowired
	private CompanyRepository repository;
		
	@Override
	public CompanyRequest create(CompanyRequest dto) {
		var company = new Company();
		company.setName(dto.getName());
		company.setBalance(dto.getBalance());
		
		return CompanyRequest.build(repository.save(company));
	}

	@Override
	public CompanyRequest update(CompanyRequest dto) {
		Company company = repository.findById(dto.getId())
							.orElseThrow(() -> new NotFoundException("Company not found"));
		
		company.setBalance(dto.getBalance());
		company.setName(dto.getName());
		
		return CompanyRequest.build(repository.save(company));
	}

	@Override
	public Integer delete(Integer id) {
		 repository.findById(id)
         	.orElseThrow(() -> new NotFoundException("Company not found"));
		
		repository.deleteById(id);
		return id;
	}

	@Override
	public List<CompanyRequest> read(CompanyRequest dto) {
		Company company = new Company();
		company.setName(dto.getName());
		company.setBalance(dto.getBalance());
		
		Specification<Company> spec = new CompanySpecification(company);
		
		return repository
				  .findAll(spec)
				  .stream()
				  .map(CompanyRequest::build)
				  .collect(Collectors.toList());
	}
  
}
