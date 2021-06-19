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

	@NotNull
	private Double salary;

	private Double balance;
	
	public EmployeeRequest() {}
	
	public EmployeeRequest(Integer id, @NotEmpty String name, @NotNull Integer company, Double salary, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.salary = salary;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double balance) {
		this.salary = balance;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public static EmployeeRequest build(Employee employee) {
		return new EmployeeRequest(
			employee.getId(),
			employee.getName(), 
			employee.getIdCompany(), 
			employee.getSalary(),
			employee.getBalance()
		);
	}
}
