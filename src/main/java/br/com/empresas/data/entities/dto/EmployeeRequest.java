package br.com.empresas.data.entities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.empresas.data.entities.model.Employee;

public class EmployeeRequest {
	private Integer id;
	
	@NotEmpty
	private String name;	

	@NotNull
	private Integer company;

	private Double balance;
	
	public EmployeeRequest() {}
	
	public EmployeeRequest(Integer id, @NotEmpty String name, @NotNull Integer company, Double balance) {
		super();
		this.id = id;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static EmployeeRequest build(Employee employee) {
		return new EmployeeRequest(
			employee.getId(),
			employee.getName(), 
			employee.getIdCompany(), 
			employee.getBalance()
		);
	}
}
