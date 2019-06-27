package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.ModelPedido;
import br.ufc.web.model.ModelPrato;

@Controller
@RequestMapping("/pedidos")
public class ControllerPedidos {
//	@Autowired
//	private 
	
//	@RequestMapping("/adicionar/{codigo}")
//	public String adicionar(@PathVariable("codigo") Long codigo, HttpSession session) {
//		ModelProduto mProduto = new ModelProduto();
//		Double total;
//		if(session.getAttribute("cesta") == null) {
//			List<ModelPedido> cesta = new ArrayList<ModelPedido>();
//			cesta.add(new ModelPedido(mProduto.find(codigo), 1));
//			session.setAttribute("cesta", cesta);
//		}
//		else {
//			List<ModelPedido> cesta = (List<ModelPedido>) session.getAttribute("cesta");
//			int index = this.existe(codigo, cesta);
//			
//			if(index == -1) {
//				cesta.add(new ModelPedido(mProduto.find(codigo), 1));
//			}
//			else {
//				int quantidade = cesta.get(index).getQuantidade() + 1;
//				cesta.get(index).setQuantidade(quantidade);
//			}
//			
//		}
//		
//		return "redirect:/pratos";
//	}
//	
//	
//	@RequestMapping("/remove{/codigo}")
//	public String remove(@PathVariable("codigo") Long codigo, HttpSession session) {
//		ModelProduto mProduto = new ModelProduto();
//		List<ModelPedido> cesta = (List<ModelPedido>) session.getAttribute("cesta");
//		int index = this.existe(codigo, cesta);
//		cesta.remove(index);
//		session.setAttribute("cesta", cesta);
//		
//		return "redirect:/pratos";
//	}
//	
//	
//	
//	private int existe(Long codigo, List<ModelPedido> cesta) {
//		for(int i = 0; i < cesta.size(); i ++) {
//			if(cesta.get(i).getmPrato().getCodigo() == codigo) {
//				return 1;
//			}
//		}
//		return -1;
//	}
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/adicionar/{codigo}")
//	public ModelAndView adicionar(@PathVariable("codigo") Long codigo, ModelPrato mP, /*int quantidade,*/ HttpSession session) {
	@RequestMapping("/adicionar")
	public ModelAndView adicionar(HttpSession session) {
		ModelPrato prato = (ModelPrato) session.getAttribute("prato");
		ModelPedido mPedido = new ModelPedido();
		mPedido.setmPrato(prato);
//		mPedido.setQuantidade(quantidade);
		mPedido.setQuantidade(1);
		
		System.out.println(prato.getNome());
		System.out.println(prato.getCodigo());
		
		List<ModelPedido> pedidos = new ArrayList<>();
		if(session.getAttribute("pedidos") != null) {
			int count = 0;
			pedidos = (List<ModelPedido>) session.getAttribute("pedidos");
			for(ModelPedido pedido: pedidos) {
				if(pedido.getmPrato().getCodigo() == prato.getCodigo()) {
					pedido.setQuantidade(mPedido.getQuantidade() + pedido.getQuantidade());
					count ++;
				}
			}
			if(count != 0) {
				pedidos.add(mPedido);
			}
		}
		else {
			pedidos.add(mPedido);
		}
		
		session.setAttribute("pedidos", pedidos);
		ModelAndView mv = new ModelAndView("redirect:/pratos");
		
		return mv;
	}
	
}
