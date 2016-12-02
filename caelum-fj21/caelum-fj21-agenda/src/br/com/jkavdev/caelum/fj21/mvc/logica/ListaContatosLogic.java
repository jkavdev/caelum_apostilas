package br.com.jkavdev.caelum.fj21.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao contatoDao = new ContatoDao(connection);

		request.setAttribute("contatos", contatoDao.getContatos());

		return "/WEB-INF/views/lista-contatos.jsp";
	}

}
