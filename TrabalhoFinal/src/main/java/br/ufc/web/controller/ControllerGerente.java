package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.ModelPrato;
import br.ufc.web.service.ServicePrato;

@Controller
@RequestMapping("/tropical")
public class ControllerGerente {
	
	@Autowired
	private ServicePrato sPrato;
	
	
	@RequestMapping("/cadastrarPrato")
//	public ModelAndView cadastrarPrato() {
	public ModelAndView cadastrarPrato(ModelPrato prato) {
		ModelAndView mv = new ModelAndView("cadastrarPrato");
//		mv.addObject("prato", new ModelPrato());
		mv.addObject("prato", prato);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar (@Validated ModelPrato prato, BindingResult result, 
								@RequestParam(value="imagemPrato") MultipartFile imagem) {
		
		ModelAndView mv = new ModelAndView("redirect:/tropical/cadastrarPrato");
		
		System.out.println(prato.getPreco());
		
		
		if(result.hasErrors()) {
//			return cadastrarPrato(prato);
			System.out.println(result.toString());
			return mv;
//			return cadastrarPrato(prato);
		}
		
		System.out.println("passou");
		sPrato.pratoCadastrar(prato, imagem);
		
		mv.addObject("mensagem", "Prato cadastrado com sucesso!");
		System.out.println("return");
		return mv;
	}
	
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView deletar(@PathVariable Long codigo) {
		sPrato.pratoExcluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		
		return mv;
	}
}
