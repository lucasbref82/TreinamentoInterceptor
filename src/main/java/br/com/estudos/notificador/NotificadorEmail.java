package br.com.estudos.notificador;

import org.springframework.stereotype.Component;

import br.com.estudos.modelo.Cliente;

@Component	
@TipoNotificador(NivelUrgencia.NORMAL)
public class NotificadorEmail implements Notificador{
	
	private boolean caixaAlta;
	private String servidorSmtp;
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if(caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		System.out.printf("Notificando cliente %s através do email %s, usando SMTP %s: %s\n"
				,cliente.getNome(), cliente.getEmail(), this.servidorSmtp,  mensagem);
	}
	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
}
