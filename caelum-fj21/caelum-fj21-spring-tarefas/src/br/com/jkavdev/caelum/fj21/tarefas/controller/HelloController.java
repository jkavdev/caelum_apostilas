package br.com.jkavdev.caelum.fj21.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/ola")
	public String hello() {
		System.out.println("Executando lógica com Spring MVC");

		return "ok";
	}

}
