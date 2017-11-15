package br.com.freetime.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco {

	private String cep;
	
	private String Logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private Pais pais;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, Pais pais) {
		super();
		this.cep = cep;
		Logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}
