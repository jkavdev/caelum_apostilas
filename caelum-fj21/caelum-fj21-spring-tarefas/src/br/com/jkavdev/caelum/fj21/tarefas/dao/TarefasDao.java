package br.com.jkavdev.caelum.fj21.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
