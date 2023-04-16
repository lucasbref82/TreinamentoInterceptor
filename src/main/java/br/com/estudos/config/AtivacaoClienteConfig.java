package br.com.estudos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.estudos.service.AtivacaoClienteService;

@Configuration
public class AtivacaoClienteConfig {
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService();
	}
}
