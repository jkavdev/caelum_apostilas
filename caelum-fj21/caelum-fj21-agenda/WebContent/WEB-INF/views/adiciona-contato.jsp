<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<html>
<body>

	<c:import url="cabecalho.jsp" />
	
	<h1>Adiciona Contatos</h1>
	<hr />
	
	<form action="mvc?logica=SalvaContatoLogic" method="post">
		<input type="hidden" name="id" value="${contato.id}">
		
		Nome: <input type="text" name="nome" value="${contato.nome}"/><br /> 
		E-mail: <input type="text" name="email" value="${contato.email}"/><br /> 
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br /> 
		Data Nascimento: <caelum:campo-data id="dataNascimento" value="${contato.dataNascimento.time}"/><br /> 
		
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp" />
</body>
</html>