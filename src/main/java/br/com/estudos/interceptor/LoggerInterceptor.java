package br.com.estudos.interceptor;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.java.Log;
import net.sf.json.JSONObject;

@Component
@Log
public class LoggerInterceptor extends HandlerInterceptorAdapter {

	private static final String IDENTIFICADOR = "identificador";
	private static final String URL = "url";
	private static final String METODO = "metodo";
	private static final String STATUS = "status";
	private static final String INICIO = "inicio";
	private static final String FIM = "fim";
	private static final String DURACAO = "duracao";

	private static final String PATTERN_FORMAT = "dd/MM/yyyy HH:mm:ss";
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Instant inicio = Instant.now();
		String identidicador = UUID.randomUUID().toString();
		request.setAttribute(INICIO, inicio.toEpochMilli());
		request.setAttribute(IDENTIFICADOR, identidicador);

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		Instant inicio = Instant.ofEpochMilli((Long) request.getAttribute(INICIO));
		Instant fim = Instant.now();
		String identificador = (String) request.getAttribute(IDENTIFICADOR);
		JSONObject mensagem = new JSONObject();
		mensagem.put(IDENTIFICADOR, identificador);
		mensagem.put(URL, request.getRequestURL().toString());
		mensagem.put(STATUS, response.getStatus());
		mensagem.put(METODO, request.getMethod());
		mensagem.put(INICIO, formatter.format(inicio));
		mensagem.put(FIM, formatter.format(fim));
		mensagem.put(DURACAO, fim.toEpochMilli() - inicio.toEpochMilli());
		
		log.info(mensagem.toString());

	}
}