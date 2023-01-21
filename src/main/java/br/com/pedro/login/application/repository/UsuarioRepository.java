package br.com.pedro.login.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedro.login.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

      public Usuario findByUsername(String username);

}

