package br.com.jkavdev.caelum.fj21.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jkavdev.caelum.fj21.tarefas.model.Tarefa;
import br.com.jkavdev.caelum.fj21.tarefas.util.ConnectionFactory;

public class TarefasDao {

	private Connection connection;

	public TarefasDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Tarefa tarefa) {
		String insertTarefa = "insert into Tarefas(descricao, finalizado, dataFinalizacao) values(?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertTarefa);

			preparedStatement.setString(1, tarefa.getDescricao());
			preparedStatement.setBoolean(2, tarefa.isFinalizado());
			preparedStatement.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));

			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Tarefa> getTarefas() {
		try {
			List<Tarefa> tarefas = new ArrayList<>();
			PreparedStatement preparedStatement = this.connection.prepareStatement("select * from Tarefas");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getLong("id"));
				tarefa.setDescricao(resultSet.getString("descricao"));
				tarefa.setFinalizado(resultSet.getBoolean("finalizado"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);

				tarefas.add(tarefa);
			}

			resultSet.close();
			preparedStatement.close();

			return tarefas;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from Tarefas where id=?");
			stmt.setLong(1, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tarefa pesquisar(Long id) {
		Tarefa tarefa = new Tarefa();
		String selectPorId = "select * from Tarefas where id = ?";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(selectPorId);
			preparedStatement.setLong(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				tarefa.setId(resultSet.getLong("id"));
				tarefa.setDescricao(resultSet.getString("descricao"));
				tarefa.setFinalizado(resultSet.getBoolean("finalizado"));

				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			}

			resultSet.close();
			preparedStatement.close();

			return tarefa;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void altera(Tarefa tarefa) {
		String alteraContato = "update Tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(alteraContato);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			
			stmt.setLong(4, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finaliza(Long id) {
		String finalizaTarefa = "update Tarefas set finalizado=? where id=?";
		boolean tarefaFinalizada = true;
		try {
			PreparedStatement stmt = connection.prepareStatement(finalizaTarefa);			
			stmt.setBoolean(1, tarefaFinalizada);
			
			stmt.setLong(2, id);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
