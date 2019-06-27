package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
//		mv.addObject("usuario", new ModelUsuario());
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping("/pratos")
	public ModelAndView pratos() {
		List <ModelPrato> pratos = sPrato.pratoListarTodos();
		ModelAndView mv = new ModelAndView("pratos");
		mv.addObject("pratos", pratos);
		
		return mv;
	}
	
	@RequestMapping("/sobre")
	public ModelAndView sobre() {
		ModelAndView mv = new ModelAndView("sobre");
		
		return mv;
	}
}
