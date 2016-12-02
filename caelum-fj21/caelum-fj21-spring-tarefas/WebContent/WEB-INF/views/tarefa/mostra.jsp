<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<html>

<head>
	<link href="resources/css/jquery-ui.min.css" rel="stylesheet" />
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/jquery-ui.min.js"></script>
</head>

<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" /> Descrição:<br />
		<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
		
		<br /> 
		
		Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' } /> 
		
		<br /> 
		
		Data de finalização: <br />
		<caelum:campo-data id="dataFinalizacao" value="${tarefa.dataFinalizacao.time}" /><br />
		
		<br /> 
		
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>