package br.com.jkavdev.caelum.fj21.tarefas.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors()){
			return "tarefa/formulario"; 
		}
		
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		TarefasDao tarefasDao = new TarefasDao();
		tarefasDao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

}
