package br.com.empresas.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresas.data.entities.model.User;

public interface CompanyRepository extends JpaRepository<User, Integer> {
}
