package br.com.jkavdev.caelum.fj21.tarefas.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.caelum.fj21.tarefas.dao.TarefasDao;
import br.com.jkavdev.caelum.fj21.tarefas.model.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {
		
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		TarefasDao tarefasDao = new TarefasDao();
		tarefasDao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

}
