<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<html>
<body>

	<c:import url="cabecalho.jsp" />
	
	<h1>Adiciona Contatos</h1>
	<hr />
	
	<form action="adicionaContato" method="post">
		Nome: <input type="text" name="nome" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Endere�o: <input type="text" name="endereco" /><br /> 
		Data Nascimento: <caelum:campo-data id="dataNascimento" /><br /> 
		
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp" />
</body>
</html>