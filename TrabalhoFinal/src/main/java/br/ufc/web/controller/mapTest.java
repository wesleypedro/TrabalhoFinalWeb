package br.ufc.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.ModelPrato;
import br.ufc.web.service.ServicePrato;

@Controller
@RequestMapping("/teste")
public class mapTest {
	
	ServicePrato sPrato;
	
	@RequestMapping("/index")
	public String index() {
		return "index";	
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";	
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";	
	}
	
	@RequestMapping("/listarPratos")
	public String listarPratos() {
		return "listarPratos";	
	}
	
	@RequestMapping("/cadastrarPrato")
	public String cadastrarPrato() {
		return "cadastrarPrato";	
	}
	
	@RequestMapping("/pedidos")
	public String pedidos() {
		return "pedidos";	
	}
	
	@RequestMapping("/historicoPedidos")
	public String historicoPedidos() {
		return "historicoPedidos";	
	}
	
//	@RequestMapping("/cadastrarprato")
//	public String cadastrarprato() {
//		return "CadastrarPrato";	
//	}
//	
//	@RequestMapping("/pratoslistar")
//	public ModelAndView pratoslistar() {
//		List <ModelPrato> pratos = sPrato.pratoListarTodos();
//		ModelAndView mv = new ModelAndView("listarPratos");
//		mv.addObject("listaPratos", pratos);
//		
//		return mv;
//	} 
//	
//	@RequestMapping("/index")
//	public String Home() {
//		return "index";	
//	}
//	
//	@RequestMapping("/index")
//	public String Home() {
//		return "index";	
//	}
//	
//	@RequestMapping("/index")
//	public String Home() {
//		return "index";	
//	}
//	
//	@RequestMapping("/index")
//	public String Home() {
//		return "index";	
//	}
}

//@Controller
//@RequestMapping("/erro")
//public class Error {
//	
//}
