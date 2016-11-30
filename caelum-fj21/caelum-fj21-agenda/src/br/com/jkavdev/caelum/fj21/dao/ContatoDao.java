package br.com.jkavdev.caelum.fj21.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jkavdev.caelum.fj21.modelo.Contato;
import br.com.jkavdev.caelum.fj21.util.ConnectionFactory;

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
			throw new DaoException(e);
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
			throw new DaoException(e);
		}
	}

	public List<Contato> pesquisarPorNome(String nome) {
		String selectPorNome = "select * from Contatos where nome like ?";

		try {
			List<Contato> contatos = new ArrayList<>();

			PreparedStatement preparedStatement = this.connection.prepareStatement(selectPorNome);
			preparedStatement.setString(1, nome + "%");

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
			throw new DaoException(e);
		}
	}

	public Contato pesquisar(Long id) {
		Contato contato = new Contato();
		String selectPorId = "select * from Contatos where id = ?";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(selectPorId);
			preparedStatement.setLong(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}

			resultSet.close();
			preparedStatement.close();

			return contato;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void altera(Contato contato) {
		String alteraContato = "update contatos set nome=?, email=?, endereco=?," + "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(alteraContato);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
