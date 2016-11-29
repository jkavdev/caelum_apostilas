package br.com.jkavdev.caelum.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jkavdev.caelum.fj21.jdbc.ConnectionFactory;
import br.com.jkavdev.caelum.fj21.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String insertContato = "insert into contatos(nome, email, endereco, dataNascimento) values(?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertContato);

			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getEmail());
			preparedStatement.setString(3, contato.getEndereco());
			preparedStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getContatos() {
		try {
			List<Contato> contatos = new ArrayList<>();
			PreparedStatement preparedStatement = this.connection.prepareStatement("select * from Contatos");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Contato contato = new Contato();
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			resultSet.close();
			preparedStatement.close();

			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
