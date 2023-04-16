package br.com.estudos.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import br.com.estudos.modelo.Cliente;
import br.com.estudos.notificador.NivelUrgencia;
import br.com.estudos.notificador.Notificador;
import br.com.estudos.notificador.TipoNotificador;

public class AtivacaoClienteService {
	// Ponto de injeção de dependência no atributo
	@TipoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;

	// Ponto de injeção de dependência no construtor.
	// @AutoWired
	// public AtivacaoClienteService(Notificador notificador) {
	// this.notificador = notificador;
	// }
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void ativar(Cliente cliente) {
		cliente.ativarCliente();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo !");
	}
	
	//@Bean(initMethod = "init", destroyMethod = "destroy") na classe de configuração
	// Ciclo de vida dos beans, é chamado após a iniciação dos beans.
	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}
	
	// Ciclo de vida dos beans, é chamado antes do bean ser destruido.
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	// Ponto de injeção de dependência no método set
//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
}
