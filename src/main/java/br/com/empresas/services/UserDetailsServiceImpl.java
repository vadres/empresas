package br.com.empresas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empresas.data.repositories.UserRepository;
import br.com.empresas.entities.dto.UserDetailsImpl;
import br.com.empresas.entities.model.User;

@Service
public class UserDetailsServiceImpl implements  org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
    UserRepository userRepo;
	
    @Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByLogin(username).orElseThrow();
		
		return UserDetailsImpl.build(user);
	}	
	
	
	
}
