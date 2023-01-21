package br.com.pedro.login.test;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.pedro.login.application.repository.UsuarioRepository;
import br.com.pedro.login.application.service.UsuarioService;
import br.com.pedro.login.domain.usuario.Usuario;

@Component
public class InsertDataForTesting {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		addUsuario();
	}
	
	
	public void addUsuario() {
		
		try {
			Usuario usu = new Usuario();
			usu.setUsername("pedro46tr@gmail.com");
			usu.setPassword("123456");
			usuarioService.saveUsuario(usu);
			
			usu = new Usuario();
			usu.setUsername("joaoTeste@gmail.com");
			usu.setPassword("joaoSenha123");
			usuarioService.saveUsuario(usu);
			
			usu = new Usuario();
			usu.setUsername("c@gmail.com");
			usu.setPassword("c");
			usuarioService.saveUsuario(usu);
			
			
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
		
	}
	

}
