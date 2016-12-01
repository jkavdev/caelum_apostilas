<%@page import="br.com.jkavdev.caelum.fj21.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>

	<c:import url="cabecalho.jsp" />

	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Email</td> 
			<td>Endereço</td>
			<td>Data de Nascimento</td>
			<td>Ações</td>
		</tr>

		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td><c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
						E-mail não informado
					</c:otherwise>
					</c:choose></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">remover</a></td>
			</tr>
		</c:forEach>

	</table>

	<c:import url="rodape.jsp" />

</body>
</html>