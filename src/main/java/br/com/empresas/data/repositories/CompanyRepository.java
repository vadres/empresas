package br.com.empresas.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.empresas.data.entities.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {
}
