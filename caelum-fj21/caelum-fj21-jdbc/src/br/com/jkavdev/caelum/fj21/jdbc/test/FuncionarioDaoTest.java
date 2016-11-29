package br.com.jkavdev.caelum.fj21.jdbc.test;

import java.sql.SQLException;

import br.com.jkavdev.caelum.fj21.jdbc.dao.FuncionarioDao;
import br.com.jkavdev.caelum.fj21.modelo.Funcionario;

public class FuncionarioDaoTest {

	public static void main(String[] args) throws SQLException {
		Funcionario jhonatan = criaFuncionario("Jhonatan", "jhonatan", "123");
		Funcionario lucas = criaFuncionario("Lucas", "lucas", "123");
		Funcionario douglas = criaFuncionario("Douglas", "douglas", "123");
		Funcionario maria = criaFuncionario("Maria", "maria", "123");

		FuncionarioDao funcionarioDao = new FuncionarioDao();

		funcionarioDao.adiciona(maria);
		funcionarioDao.adiciona(jhonatan);
		funcionarioDao.adiciona(lucas);
		funcionarioDao.adiciona(douglas);

		System.out.println("Funcionários adicionados!");

	}

	public static Funcionario criaFuncionario(String nome, String usuario, String senha) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setSenha(senha);
		funcionario.setUsuario(usuario);

		return funcionario;
	}

}
