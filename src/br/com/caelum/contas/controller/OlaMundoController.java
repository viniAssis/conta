package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olamundo")
	public String action() {
		
		System.out.println("deu certo bixo");	
		return "ok";
	}
}
