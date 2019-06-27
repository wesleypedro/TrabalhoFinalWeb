package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.web.model.ModelPedido;
import br.ufc.web.model.ModelUsuario;
import br.ufc.web.service.ServiceUsuario;

@Controller
@RequestMapping("/user")
public class ControllerUsuario {
	
	@Autowired
	ServiceUsuario sUsuario;
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Validated ModelUsuario usuario,  BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("cadastro");
		if(result.hasErrors()) {
			System.out.println("hasErrors()");
			return mv;
		}
		
		int ret = sUsuario.usuarioCadastrar(usuario);
		
		System.out.println("ret -> "+ret);
		
		if(ret == 0) {
			mv.addObject("mensagem", "Email e/ou CPF já estão cadastrados!");
			
			System.out.println(mv.toString());
			
			return mv;
		}
		
		if(ret == 1) {
			mv = new ModelAndView("login");
			mv.addObject("mensagem", "Usuário cadastrado com sucesso!");
		}
		
		return mv;
	}
	
	@RequestMapping("/pedidos")
	public ModelAndView pedidos(HttpSession session) {
		ModelAndView mv = new ModelAndView("pedidos");
		
		if(session.getAttribute("pedidos") != null) {
			mv.addObject("pedidos", (List<ModelPedido>) session.getAttribute("pedidos"));
		}
		else {
			List<ModelPedido> pedidos = new ArrayList<ModelPedido>();
			session.setAttribute("pedidos", pedidos);
			mv.addObject("pedidos", (List<ModelPedido>) session.getAttribute("pedidos"));
		}
		
		return mv;
	}
		
	@RequestMapping("/historico")
	public ModelAndView historico() {
		ModelAndView mv = new ModelAndView("historico");
		
		return mv;
	}		
}
