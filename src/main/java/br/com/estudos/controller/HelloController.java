package br.com.estudos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.modelo.Cliente;
import br.com.estudos.service.AtivacaoClienteService;

@RestController
public class HelloController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	public HelloController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}
	
	@GetMapping("/ativacao-cliente")
	public void ativacao() {
		Cliente lucas = new Cliente("Lucas", "lucasbref82@gmail.com", "31994372780");
		ativacaoClienteService.ativar(lucas);
	}
	
}
