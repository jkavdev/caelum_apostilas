package br.com.jkavdev.caelum.fj21.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		ContatoDao contatoDao = new ContatoDao();
		contatoDao.remove(contato);

		System.out.println("Excluindo contato ....");

		return "redirect:/lista-contatos-foreach.jsp";
	}

}
