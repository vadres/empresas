package br.com.empresas.data.entities.dto;

import org.springframework.security.core.GrantedAuthority;

public class RoleAdminRequest implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return "admin";
	}	
	
}
