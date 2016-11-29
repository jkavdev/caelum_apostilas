package br.com.jkavdev.caelum.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.caelum.fj21.jdbc.ConnectionFactory;
import br.com.jkavdev.caelum.fj21.modelo.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario Funcionario) {
		String insertFuncionario = "insert into Funcionarios(nome, usuario, senha) values(?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertFuncionario);

			preparedStatement.setString(1, Funcionario.getNome());
			preparedStatement.setString(2, Funcionario.getUsuario());
			preparedStatement.setString(3, Funcionario.getSenha());

			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Funcionario> getFuncionarios() {
		try {
			List<Funcionario> Funcionarios = new ArrayList<>();
			PreparedStatement preparedStatement = this.connection.prepareStatement("select * from Funcionarios");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Funcionario Funcionario = new Funcionario();
				Funcionario.setNome(resultSet.getString("nome"));
				Funcionario.setUsuario(resultSet.getString("usuario"));
				Funcionario.setSenha(resultSet.getString("senha"));

				Funcionarios.add(Funcionario);
			}

			resultSet.close();
			preparedStatement.close();

			return Funcionarios;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
