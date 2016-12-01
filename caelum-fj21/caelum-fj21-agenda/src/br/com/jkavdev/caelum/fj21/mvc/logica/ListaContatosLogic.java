package br.com.jkavdev.caelum.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("contatos", new ContatoDao().getContatos());

		return "/WEB-INF/views/lista-contatos-foreach.jsp";
	}

}
