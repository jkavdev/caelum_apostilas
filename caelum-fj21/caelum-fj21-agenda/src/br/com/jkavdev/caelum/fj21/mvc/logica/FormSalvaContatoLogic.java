package br.com.jkavdev.caelum.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;

public class FormSalvaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = null;

		if (request.getParameterMap().containsKey("id") && !request.getParameter("id").isEmpty()) {
			id = Long.parseLong(request.getParameter("id"));
			request.setAttribute("contato", new ContatoDao().pesquisar(id));

			return "/WEB-INF/views/adiciona-contato.jsp";
		}

		return "/WEB-INF/views/adiciona-contato.jsp";
	}

}
