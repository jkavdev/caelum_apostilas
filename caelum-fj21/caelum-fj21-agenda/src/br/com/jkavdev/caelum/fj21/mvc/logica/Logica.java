package br.com.jkavdev.caelum.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
