<%@page import="br.com.jkavdev.caelum.fj21.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<html>
<body>
	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.dao.ContatoDao"/>
	
	<table>
	
		<c:forEach var="contato" items="${dao.contatos}">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>