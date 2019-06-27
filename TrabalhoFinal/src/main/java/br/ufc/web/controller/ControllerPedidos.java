package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.ModelPedido;
import br.ufc.web.model.ModelPrato;
import br.ufc.web.service.ServicePrato;

@Controller
@RequestMapping("/pedidos")
public class ControllerPedidos {
	@Autowired
	private ServicePrato sPrato;
	
	
	@RequestMapping("/adicionar/{codigo}")
	public ModelAndView adicionar(@PathVariable("codigo") Long codigo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/pratos");

		boolean existe = false;
		ModelPrato mPrato = sPrato.pratoBuscarPorCodigo(codigo);
		
		if(session.getAttribute("pedidos") == null) {
			ModelPedido pedido = new ModelPedido(mPrato, 1);
			
			List<ModelPedido> pedidos = new ArrayList<ModelPedido>();
			pedidos.add(pedido);

			session.setAttribute("pedidos", pedidos);
		}
		else {
			List<ModelPedido> pedidos = (List<ModelPedido>) session.getAttribute("pedidos");
			
			for(ModelPedido pedido: pedidos) {
				if(pedido.getmPrato().getCodigo() == mPrato.getCodigo()) {
					pedido.setQuantidade(pedido.getQuantidade() + 1);
					pedidos.add(pedido);
					existe = true;
				}
			}
			
			if(!existe) {
				ModelPedido pedido = new ModelPedido(mPrato, 1);
				pedidos.add(pedido);
			}
			
			session.setAttribute("pedidos", pedidos);
		}
		
		return mv;
	}
	
	
	@RequestMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		
		int index = 0;
		List<ModelPedido> pedidos = (List<ModelPedido>) session.getAttribute("pedidos");
		
		for(ModelPedido pedido: pedidos) {
			if(pedido.getmPrato().getCodigo() == codigo) {
				pedidos.remove(index);
				break;
			}
			index ++;
		}
		
		
		return mv;
	}
}
