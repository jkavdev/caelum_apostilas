<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="true" %>

<input id="${id}" name="${id}" type="text" value="${value}">

<script>
	$('#${id}').datepicker();
</script>
