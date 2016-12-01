package br.com.jkavdev.caelum.fj21.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.modelo.Contato;

public class SalvaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = 0;

		if (req.getParameterMap().containsKey("id") && !req.getParameter("id").isEmpty())
			id = Long.parseLong(req.getParameter("id"));

		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			return "mvc?logica=ListaContatosLogic";
		}

		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		ContatoDao dao = new ContatoDao();
		if (contato.getId() == 0)
			dao.adiciona(contato);
		else
			dao.altera(contato);

		return "mvc?logica=ListaContatosLogic";
	}

}
