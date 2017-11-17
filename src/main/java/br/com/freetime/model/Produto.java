package br.com.freetime.model;

import java.math.BigDecimal;

public class Produto extends Evento{

	private int quantidade;

	private int idadeMinima;
	
	private int idadeMaxima;
	
	private BigDecimal valor;
	
	private TipoProduto tipoProduto;
	
}
