package br.com.freetime.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Evento")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private List<Categoria> categorias = new ArrayList<>();
	
	private Date dataCriacao;
	
	private Date dataTermino;
	
	private Endereco local;
	
	private int quantidadePessoas;
	
	private List<Cliente> pessoasInscritas;
	
	private String descricao;
	
	private String informacoes;
	
	public Evento() {}

	public Evento(String nome, List<Categoria> categorias, Date dataCriacao, Date dataTermino, Endereco local,
			int quantidadePessoas, String descricao, String informacoes) {
		super();
		this.nome = nome;
		this.setCategorias(categorias);
		this.dataCriacao = dataCriacao;
		this.dataTermino = dataTermino;
		this.local = local;
		this.quantidadePessoas = quantidadePessoas;
		this.descricao = descricao;
		this.informacoes = informacoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
