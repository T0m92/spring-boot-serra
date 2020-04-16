package it.agriBoot.utils;

public class ProfiloDTO {
	
	/*n.b. l'ordine in cui sono dichiarate queste variabili sarà quello con cui jackson serializzerà l'oggetto quindi cambiando l'ordine
	 * delle dichiarazioni di variabile cambierà l'ordine di come verranno stampati in JSON i risultati
	 * */
	private Integer idSerra;//ID della serra
	private String nomeSerra;//NOME della serra
	private Integer idProfilo; //ID del profilo
	private String nomeProfilo;//NOME del profilo
	private Long contaConfAssociateProfilo;//CONTATORE delle configurazioni associate a ciascun profilo
	
	//n.b. ogni entry-profilo avrà il suo DTO creato a runtime
	// bisogna passare nella query alla chiamata al seguente costruttori i parametri nello stesso ordine, altrimenti si solleva un'eccezione
	public ProfiloDTO(Integer idSerra,String nomeSerra, Integer idProfilo, String nomeProfilo, Long contaConfAssociateProfilo) {
		this.idProfilo = idProfilo;
		this.nomeProfilo=nomeProfilo;
		this.contaConfAssociateProfilo =contaConfAssociateProfilo;
		this.idSerra=idSerra;
		this.nomeSerra=nomeSerra;		
	}

	public Integer getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	public String getNomeProfilo() {
		return nomeProfilo;
	}

	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}

	public Long getContaConfAssociateProfilo() {
		return contaConfAssociateProfilo;
	}

	public void setContaConfAssociateProfilo(Long contaConfAssociateProfilo) {
		this.contaConfAssociateProfilo = contaConfAssociateProfilo;
	}

	public Integer getIdSerra() {
		return idSerra;
	}

	public void setIdSerra(Integer idSerra) {
		this.idSerra = idSerra;
	}

	public String getNomeSerra() {
		return nomeSerra;
	}

	public void setNomeSerra(String nomeSerra) {
		this.nomeSerra = nomeSerra;
	}

}