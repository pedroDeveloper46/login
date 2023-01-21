package br.com.pedro.login.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.pedro.login.domain.usuario.Usuario;

public class SecurityUtils {
	
	public static LoggedUser loggedUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}
		
		return (LoggedUser) authentication.getPrincipal();
		
	}
	
	public static Usuario loggedUsuario() {
		LoggedUser logged = loggedUser();
		
		if (logged == null) {
			throw new IllegalStateException("Não existe um usuário logado");
		}
		
		return (Usuario) logged.getUsuario();
		
	}

}
