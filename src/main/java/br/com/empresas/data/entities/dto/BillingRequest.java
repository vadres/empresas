package br.com.empresas.data.entities.dto;

import javax.validation.constraints.NotNull;

public class BillingRequest {
	@NotNull
	private Integer company;
	
	@NotNull
	private Integer employee;
    
	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
}
