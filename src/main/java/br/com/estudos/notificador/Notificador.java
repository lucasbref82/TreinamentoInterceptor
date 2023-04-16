package br.com.estudos.notificador;

import br.com.estudos.modelo.Cliente;

public interface Notificador {
	void notificar(Cliente cliente, String mensagem);
}
