package br.com.freetime.model;

public class Pais {

	private String iso;
	
	private String nome;

	public Pais() {}

	public Pais(String iso, String nome) {
		super();
		this.iso = iso;
		this.nome = nome;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
