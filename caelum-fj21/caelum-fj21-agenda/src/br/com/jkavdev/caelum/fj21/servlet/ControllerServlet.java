package br.com.jkavdev.caelum.fj21.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.com.jkavdev.caelum.fj21.mvc.logica." + parametro;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(req, resp);

			resp.sendRedirect(pagina);
			req.getRequestDispatcher(pagina).forward(req, resp);			
		} catch (Exception e) {
			throw new ServletException("Lógica de negócio causou uma exceção: " + e.getMessage(), e);
		}
	}

}
