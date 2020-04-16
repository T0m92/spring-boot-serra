package it.agriBoot.utils;

public class SerraDTO {
	private Integer id; //ID della serra
	private String nome;//NOME della serra
	//long perchè la COUNT di MySLQ sertituisce un long
	private Long cont;
	
	//costruttore della classe SerraDTO
	//N.B.: l'ordine dei parametri passati nel costruttore deve rispettare quello definito
	//all'interno della "new" inserita nella NamedQuery onde evitare eccezioni 
	public SerraDTO(String nome,Integer id,  Long cont) {
		this.setNome(nome);
		this.id = id;
		this.cont =cont;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCont() {
		return cont;
	}
	
	public void setCont(Long cont) {
		this.cont = cont;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}