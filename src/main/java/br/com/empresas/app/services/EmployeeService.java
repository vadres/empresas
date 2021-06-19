package br.com.empresas.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.empresas.data.contracts.CrudModelService;
import br.com.empresas.data.entities.dto.EmployeeRequest;
import br.com.empresas.data.entities.model.Employee;
import br.com.empresas.data.repositories.CompanyRepository;
import br.com.empresas.data.repositories.EmployeeRepository;
import br.com.empresas.data.repositories.EmployeeSpecification;
import br.com.empresas.infra.exceptions.NotFoundException;

@Service
public class EmployeeService implements CrudModelService<EmployeeRequest> {
    @Autowired
    private EmployeeRepository repository;  
    
    @Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public EmployeeRequest create(EmployeeRequest dto) {
		companyRepository.findById(dto.getCompany())
			.orElseThrow(() -> new NotFoundException("Company not found"));
		
		var employee = new Employee();
		employee.setBalance(0.0);
		employee.setSalary(dto.getSalary());
		employee.setIdCompany(dto.getCompany());
		employee.setName(dto.getName());
		
		return EmployeeRequest.build(repository.save(employee));
	}

	@Override
	public EmployeeRequest update(EmployeeRequest dto) {
		var employee = repository.findById(dto.getId())
			.orElseThrow(() -> new NotFoundException("Employee not found"));
		
		employee.setSalary(dto.getSalary());
		employee.setIdCompany(dto.getCompany());
		employee.setName(dto.getName());
		
		return EmployeeRequest.build(repository.save(employee));
	}

	@Override
	public Integer delete(Integer id) {
		 repository.findById(id)
      			.orElseThrow(() -> new NotFoundException("Employee not found"));
		
		repository.deleteById(id);
		return id;
	}

	@Override
	public List<EmployeeRequest> read(EmployeeRequest dto) {
		var employee = new Employee();
		employee.setName(dto.getName());
		employee.setId(dto.getId());
		
		Specification<Employee> spec = new EmployeeSpecification(employee);
		
		return repository
				  .findAll(spec)
				  .stream()
				  .map(EmployeeRequest::build)
				  .collect(Collectors.toList());
	}

}
