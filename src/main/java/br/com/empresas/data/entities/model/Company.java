package br.com.empresas.data.entities.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")	
    private Integer id;
	
	@Column(name = "vl_name")	
    private String name;	

	@OneToMany(mappedBy = "idCompany", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;
	
	@Column(name = "balance", columnDefinition = "numeric default 0.0")	
    private Double balance;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(name="dt_created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(name="dt_updated_at")
	private LocalDateTime updatedAt;

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

	public List<Employee> getEmployees() {
		return employees == null? new ArrayList<Employee>(): employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance == null? 0.0: balance;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
