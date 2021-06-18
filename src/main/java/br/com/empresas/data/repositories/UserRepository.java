package br.com.empresas.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresas.entities.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByLogin(String login);
	
}
