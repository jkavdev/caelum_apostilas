package br.com.jkavdev.caelum.fj21.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jkavdev.caelum.fj21.jdbc.ConnectionFactory;

public class ConexaoTest {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		System.out.println("Conexão aberta");
		
		connection.close();
	}

}
