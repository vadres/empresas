package br.com.empresas.data.entities.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtRequest {
    private String token;
    private UserDetails userDetails;
    
	public JwtRequest(String token, UserDetails userDetails) {
		super();
		this.token = token;
		this.userDetails = userDetails;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
