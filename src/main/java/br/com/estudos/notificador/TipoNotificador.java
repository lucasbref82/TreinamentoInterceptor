package br.com.estudos.notificador;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

// Anotação que define de que maneira ira rodar.
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TipoNotificador {
	NivelUrgencia value();
}
