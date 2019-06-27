package br.ufc.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class ModelPrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@NotBlank(message = "Preencha o campo de nome")
	private String nome;
	
	@NotNull(message = "Preencha o campo de preço")
	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private Double preco;
	
	private String extensao;
	
	
//	private List<ModelPedidos> pedidos;
	

	/**
	 * 
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * 
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return the extensao
	 */
	public String getExtensao() {
		return extensao;
	}

	/**
	 * @param extensao the extensao to set
	 */
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	
}
