use db_fj21;

CREATE TABLE tarefas (
	id BIGINT NOT NULL AUTO_INCREMENT,
	descricao text,
	finalizado boolean,
	dataFinalizacao DATE,
	PRIMARY KEY (id)
);