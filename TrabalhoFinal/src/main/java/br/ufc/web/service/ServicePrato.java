package br.ufc.web.service;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.web.model.ModelPrato;
import br.ufc.web.repository.RepositoryPrato;
import br.ufc.web.util.UtilPratoFile;

@Service
public class ServicePrato {
	
	@Autowired
	private RepositoryPrato rPrato;
	
	/**
	 * 
	 * @param prato - Objeto com todos os atributos de um prato
	 * @param imagem - imagem a ser "upada"
	 */
	public void pratoCadastrar(ModelPrato prato, MultipartFile imagem) {
		String extensao = FilenameUtils.getExtension(imagem.getOriginalFilename());
		String caminho = "images/" + prato.getNome()+"."+extensao;
		UtilPratoFile.pratoSalvar(caminho, imagem);
		
		prato.setExtensao(extensao);
		
		prato.getCodigo();
		
		rPrato.save(prato);
	}
	
	/**
	 * 
	 * @return retorna um ArrayList contendo todos os pratos cadastrados no sistema
	 */
	public List<ModelPrato> pratoListarTodos(){
		return rPrato.findAll();
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void pratoExcluir(Long codigo) {
		rPrato.deleteById(codigo);
	}
	
	/**
	 * 
	 * @param codigo - Codigo do prato a ser pesquisado
	 * @return o prato com o codigo pesquisado
	 */
	public ModelPrato pratoBuscarPorCodigo(Long codigo) {
		return rPrato.getOne(codigo);
	}
	
	public List<ModelPrato> pratoBuscarPorNome(String nome){
		return rPrato.findAllByNome(nome);
	}
}
