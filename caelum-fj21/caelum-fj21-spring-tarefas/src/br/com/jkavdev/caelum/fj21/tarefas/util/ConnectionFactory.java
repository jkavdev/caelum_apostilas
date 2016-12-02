package br.com.jkavdev.caelum.fj21.tarefas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_fj21", "root", "99346554");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
