package br.com.estudos.notificador;

import org.springframework.stereotype.Component;

import br.com.estudos.modelo.Cliente;

// Usada para desambiguação de beans
// @Primary
@Component
@TipoNotificador(NivelUrgencia.URGENTE)
public class NotificadorSMS implements Notificador{

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando cliente %s através do número %s: %s\n"
				, cliente.getNome()
				, cliente.getTelefone()
				, mensagem);
		
	}

}
