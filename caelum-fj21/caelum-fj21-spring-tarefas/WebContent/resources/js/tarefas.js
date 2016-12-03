function finalizaAgora(id) {
	$.post("finalizaTarefa", {
		'id' : id
	}, function() {
		// selecionando o elemento html através da
		// ID e alterando o HTML dele
		$("#tarefa_" + id).html("Finalizado");
	});
}