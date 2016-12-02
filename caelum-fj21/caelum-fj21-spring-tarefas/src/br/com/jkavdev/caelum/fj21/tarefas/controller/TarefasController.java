package br.com.jkavdev.caelum.fj21.tarefas.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

		if (result.hasFieldErrors()) {
			return "tarefa/formulario";
		}

		tarefa.setDataFinalizacao(Calendar.getInstance());

		TarefasDao tarefasDao = new TarefasDao();
		tarefasDao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", new TarefasDao().getTarefas());

		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String lista(Tarefa tarefa) {
		TarefasDao tarefasDao = new TarefasDao();
		tarefasDao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		TarefasDao tarefasDao = new TarefasDao();
		model.addAttribute("tarefa", tarefasDao.pesquisar(id));

		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		TarefasDao tarefasDao = new TarefasDao();
		tarefasDao.altera(tarefa);

		return "redirect:listaTarefas";
	}

}
