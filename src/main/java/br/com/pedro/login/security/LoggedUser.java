package br.com.pedro.login.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.pedro.login.domain.usuario.Usuario;

@SuppressWarnings("serial")
public class LoggedUser implements UserDetails {

	private Usuario usuario;
	
	private Role role;
	
	private Collection<? extends GrantedAuthority> roles;
	
	public LoggedUser(Usuario usuario) {
		
		this.usuario = usuario;

		if (usuario == null) {
			throw new IllegalStateException("Não é um usuário");
		}
		
		Role role = Role.USUARIO;
		
		this.role = role;
		
		this.roles = List.of(new SimpleGrantedAuthority("ROLE_"+ getRole()));
	
		
	}
	
	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}
	
	public Role getRole() {
		return role;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getUsuario().getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUsuario().getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
