package br.com.pedro.login.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedro.login.application.repository.UsuarioRepository;
import br.com.pedro.login.domain.usuario.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void saveUsuario(Usuario usuario) throws ValidationException {
		
		Usuario usu = usuarioRepository.findByUsername(usuario.getUsername());
		
		if (usu != null) {
	         throw new ValidationException("Esse usuário já existe");	
		}else {
			usuario.encryptSenha();
			usuarioRepository.save(usuario);
		}
		
	}

}
