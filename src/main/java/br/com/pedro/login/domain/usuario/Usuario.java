package br.com.pedro.login.domain.usuario;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import br.com.pedro.login.util.StringUtils;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("serial")
public class Usuario implements Serializable {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O username não pode ser vazio")
	@Size(max = 80, message = "O username não pode ser muito grande")
	private String username;
	
	@NotBlank(message = "A senha não pode ser vazia")
	@Size(max = 80, message = "A senha não poder ser muito grande")
	private String password;
	
	
	public void encryptSenha() {
		this.password = StringUtils.encrypt(getPassword());
	}
	

}
