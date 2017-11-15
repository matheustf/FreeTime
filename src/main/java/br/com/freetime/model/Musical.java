package br.com.freetime.model;

import java.math.BigDecimal;
import java.util.List;

//Barzinho/Show/Balada
public class Musical extends Evento{

	private List<TipoBebida> tiposBebidas;
	
	private TipoShow tipoShow;
	
	private int idadeMinima;
	
	private BigDecimal valor;
	
	private boolean consumacao;
	
}
