package br.com.freetime.model;

import java.util.Date;

public class Evento {

	private long id;
	
	private String nome;
	
	private TipoEvento tipoEvento;
	
	private Date dataCriacao;
	
	private Date dataTermino;
	
	private Endereco local;
	
	private int quantidadePessoas;
	
	private String descricao;
	
	private String informacoes;
}
