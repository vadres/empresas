package br.com.empresas.data.entities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.empresas.data.entities.model.Employee;

public class EmployeeRequest {
	@NotEmpty
	private String name;	

	@NotNull
	private Integer company;

	private Double balance;

	public EmployeeRequest(@NotEmpty String name, @NotNull Integer company, Double balance) {
		super();
		this.name = name;
		this.company = company;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public static EmployeeRequest build(Employee employee) {
		return new EmployeeRequest(
			employee.getName(), 
			employee.getIdCompany(), 
			employee.getBalance()
		);
	}
}
