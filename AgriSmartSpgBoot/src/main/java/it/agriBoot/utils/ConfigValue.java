package it.agriBoot.utils;

public class ConfigValue {
	private String nome;
	private Integer id;
	private String valori;

	public ConfigValue() {}
	
	public ConfigValue(String nome, Integer id, String valori) {
		this.nome = nome;
		this.id = id;
		this.valori = valori;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValori() {
		return valori;
	}

	public void setValori(String valori) {
		this.valori = valori;
	}
	

}
