package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.ModelPedido;
import br.ufc.web.model.ModelPrato;
import br.ufc.web.model.ModelUsuario;
import br.ufc.web.service.ServicePrato;

@Controller
public class ControllerInicial {
	
	@Autowired
	ServicePrato sPrato;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(ModelUsuario usuario) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastro(ModelUsuario usuario) {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping("/pratos")
	public ModelAndView pratos(HttpSession session) {
		List <ModelPrato> pratos = sPrato.pratoListarTodos();
		ModelAndView mv = new ModelAndView("pratos");
		mv.addObject("pratos", pratos);
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
	
	@RequestMapping("/sobre")
	public ModelAndView sobre() {
		ModelAndView mv = new ModelAndView("sobre");
		
		return mv;
	}
}
