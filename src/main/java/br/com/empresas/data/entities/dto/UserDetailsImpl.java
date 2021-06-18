package br.com.empresas.data.entities.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.empresas.data.entities.model.User;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;

    @JsonIgnore
	private String password;
       
	public UserDetailsImpl(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        var collection = new ArrayList<RoleAdminResponse>();
        collection.add(new RoleAdminResponse());
		
		return collection;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(
			user.getLogin(),
			user.getPassword()
		);
	}

}
