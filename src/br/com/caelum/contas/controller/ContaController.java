package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		
		if(conta.getDescricao().equals(" "))
			conta.setDescricao(null);
		
			
			if(result.hasErrors())
				return "formulario";
				
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);
		return "conta/conta-adicionada";
		
	}
	
	@RequestMapping(value="/form")	
		public String form(){
			return "formulario";
		}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		
		mv.addObject("contas",contas);
		
		return mv;
		
	}
	
	@RequestMapping("/removerConta")
	public String remove(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.remove(conta);
		 return "redirect:listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public ModelAndView mostra(Conta conta) {
		ContaDAO dao = new ContaDAO();
		
		ModelAndView mv = new ModelAndView("conta/editaConta");
		
		mv.addObject("conta", dao.buscaPorId(conta.getId()) );
		
		return mv;
	}
	
	@RequestMapping("/editaConta")
	public String edita(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.altera(conta);
		
		return"redirect:listaContas";
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Long id, HttpServletResponse response) {
		ContaDAO dao = new ContaDAO();
		dao.paga(id);
		System.out.println("teste");
		response.setStatus(200);
	}
	
}
