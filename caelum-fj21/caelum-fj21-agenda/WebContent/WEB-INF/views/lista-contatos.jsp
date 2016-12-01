<%@page import="br.com.jkavdev.caelum.fj21.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<body>

	<c:import url="cabecalho.jsp" />

	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.dao.ContatoDao" />

	<display:table name="${dao.contatos}">
	  <display:column property="id" title="ID" />
	  <display:column property="nome" title="Nome" sortable="true"/>
	  <display:column property="email" title="E-mail" href="mailto:email"/>
	  <display:column property="endereco" title="Endereço" />
	  <display:column property="dataNascimento.time" title="Data de nascimento" format="{0,date,dd-MM-yyyy}"/>
	</display:table>

	<c:import url="rodape.jsp" />

</body>
</html>