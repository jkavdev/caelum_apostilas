use db_fj21;

CREATE TABLE contatos (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	endereco VARCHAR(255),
	dataNascimento DATE,
	PRIMARY KEY (id)
);
