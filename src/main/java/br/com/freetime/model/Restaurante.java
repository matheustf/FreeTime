package br.com.freetime.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

//Barzinho/Show/Balada
public class Restaurante extends Evento{

	private List<TipoBebida> tiposBebidas;
	
	private List<TipoComida> tipoComida;
	
	private TipoShow tipoShow;
	
	private int idadeMinima;
	
	private BigDecimal valorDeEntrada;
	
	private boolean consumacao;
	
	//PDF
	private File cardapio;
	
}
