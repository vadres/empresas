package br.com.empresas.data.entities.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import br.com.empresas.data.entities.model.Company;

public class CompanyRequest {
	private Integer id;
	
	@NotEmpty
	private String name;	

	private List<EmployeeRequest> employees;

	private Double balance;
	
	public CompanyRequest() {}
	
	public CompanyRequest(Integer id, @NotEmpty String name, List<EmployeeRequest> employees, Double balance) {
		this.id = id;
		this.name = name;
		this.employees = employees;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeRequest> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeRequest> employees) {
		this.employees = employees;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public static CompanyRequest build(Company company) {
		return new CompanyRequest(
			company.getId(), 
			company.getName(), 
			company.getEmployees().stream().map(EmployeeRequest::build).collect(Collectors.toList()), 
			company.getBalance()
	);
	}
	
}
