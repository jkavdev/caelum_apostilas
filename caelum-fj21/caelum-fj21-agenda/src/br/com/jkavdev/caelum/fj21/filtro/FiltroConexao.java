package br.com.jkavdev.caelum.fj21.filtro;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.jkavdev.caelum.fj21.util.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();

			request.setAttribute("conexao", connection);

			chain.doFilter(request, response);

			connection.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {

	}

}
