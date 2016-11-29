package br.com.jkavdev.caelum.fj21.jdbc.test;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.jkavdev.caelum.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.modelo.Contato;

public class ContatoDaoTest {

	public static void main(String[] args) throws SQLException {
//		Contato jhonatan = criaContato("Jhonatan", "jhonatan@", "QR 12 CASA 15");
//		Contato lucas = criaContato("Lucas", "lucas@", "QR 12 CASA 14");
//		Contato douglas = criaContato("Douglas", "douglas@", "QR 12 CASA 15");
		Contato maria = criaContato("Maria", "maria@", "QR 12 CASA 15");
		maria.setId(4L);
//
		ContatoDao contatoDao = new ContatoDao();
//
//		contatoDao.adiciona(maria);
//		contatoDao.adiciona(jhonatan);
//		contatoDao.adiciona(lucas);
//		contatoDao.adiciona(douglas);
//
//		System.out.println("Contatos adicionados!");
//
//		contatoDao.getContatos().forEach(e -> System.out.println(e));
//
//		System.out.println("\n");
//		contatoDao.pesquisarPorNome("jhonatan").forEach(e -> System.out.println(e));
//
//		System.out.println("\n");
//		System.out.println(contatoDao.pesquisar(1L));
		
		contatoDao.remove(maria);
	}

	public static Contato criaContato(String nome, String email, String endereco) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(Calendar.getInstance());

		return contato;
	}

}
