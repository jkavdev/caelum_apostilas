<html>
<body>
	<%-- coment�rio em JSP aqui: nossa primeira p�gina JSP --%>
	
	<% String mensagem = "Bem vindo ao sistema de agenda do FJ-21!"; %>
	<% out.println(mensagem); %>
	
	<br />
	
	<% String desenvolvido = "Desenvolvido por (JKAVDEV)"; %>
	<%=desenvolvido%>
	
	<br />
	
	<% System.out.println("Tudo foi executado!"); %>
	
	<br /><br />
	
	<a href="mvc?logica=ListaContatosLogic">Lista de contatos</a>
	
	<br />
	
	<a href="mvc?logica=FormSalvaContatoLogic">Adicionar um contato</a>
</body>
</html>