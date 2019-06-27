package br.ufc.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class ModelItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private double valor;
	
	private int quantidade;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Ped
	
}
