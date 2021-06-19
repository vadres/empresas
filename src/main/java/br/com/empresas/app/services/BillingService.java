package br.com.empresas.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresas.data.entities.dto.BillingRequest;
import br.com.empresas.data.repositories.CompanyRepository;
import br.com.empresas.data.repositories.EmployeeRepository;
import br.com.empresas.infra.exceptions.NotFoundException;

@Service
public class BillingService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	@Transactional
	public void create(BillingRequest request) {
		var company = companyRepository.findById(request.getCompany())
				 .orElseThrow(() -> new NotFoundException("Company not found"));
		
		var employee = employeeRepository.findById(request.getEmployee())
				.orElseThrow(() -> new NotFoundException("Employee not found"));
		
		double newBalance = employee.getBalance() + employee.getSalary();
		employee.setBalance( newBalance );
		
		employeeRepository.save(employee);
		
		double total = company.getEmployees().stream()
		                  .map(e -> e.getSalary())
		                  .reduce(0.0, (subtotal, element) -> subtotal + element);
		
		newBalance = company.getBalance() - (total * 0.0038) - employee.getSalary();
		company.setBalance( newBalance );
		
		companyRepository.save(company);
	}
}
