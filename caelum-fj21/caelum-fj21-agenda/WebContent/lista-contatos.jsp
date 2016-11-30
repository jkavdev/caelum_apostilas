<%@page import="br.com.jkavdev.caelum.fj21.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<c:import url="cabecalho.jsp" />

	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.dao.ContatoDao" />

	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endere�o</td>
			<td>Data de Nascimento</td>
		</tr>

		<c:forEach var="contato" items="${dao.contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td><c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
						E-mail n�o informado
					</c:otherwise>
					</c:choose></td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento}</td>
			</tr>
		</c:forEach>

	</table>

	<c:import url="rodape.jsp" />

</body>
</html>