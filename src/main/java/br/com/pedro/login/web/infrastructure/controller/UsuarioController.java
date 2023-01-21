package br.com.pedro.login.web.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@GetMapping(path = "/home")
	public String home() {
		return "home";
	}
	
}
