package br.com.jkavdev.caelum.fj21.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_fj21", "root", "99346554");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
