package br.com.jkavdev.caelum.fj21.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ContatoDao contatoDao = new ContatoDao();
		List<Contato> contatos = contatoDao.getContatos();

		request.setAttribute("contatos", contatos);

		return "/WEB-INF/views/lista-contatos.jsp";
	}

}
