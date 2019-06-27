package br.ufc.web.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class UtilPratoFile {
	
	/**
	 * 
	 * @param caminho - hierarquia de onde a imagem sera salva
	 * @param imagem - representacao da imagem "upada"
	 */
	public static void pratoSalvar(String caminho, MultipartFile imagem) {
		File file = new File(caminho);
		
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
