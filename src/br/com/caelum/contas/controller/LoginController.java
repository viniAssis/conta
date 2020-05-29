package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("/LoginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new UsuarioDAO().existeUsuario(usuario)) {
			// usuario existe, guardaremos ele na session
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		// ele errou a senha, voltou para o formulario
		return "formulario-login";
		
	}
	
	
	@RequestMapping("/deslogarSistema")
	public String deslogar(HttpSession session) {
		
		session.invalidate();
		return "redirect:formulario-login";
		
	}
}
