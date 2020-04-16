package it.agriBoot.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table (name="apparecchiature")
@NamedQuery(name="Apparecchiature.findAll", query="SELECT a FROM Apparecchiature a")
public class Apparecchiature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="idAppar")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAppar;
	
	@Column (name="funzione")
	private String funzione;
	@Column (name="marca")
	private String marca;
	@Column (name="modello")
	private String modello;

	//bi-directional many-to-many association to Profili
	@ManyToMany(mappedBy="apparecchiatures")//, fetch = FetchType.EAGER
	//@JsonIgnoreProperties({"apparecchiature"})
	@JsonIgnore
	private List<Profili> profilis;

	public Apparecchiature() {
	}

	public Integer getIdAppar() {
		return this.idAppar;
	}

	public void setIdAppar(Integer idAppar) {
		this.idAppar = idAppar;
	}

	public String getFunzione() {
		return this.funzione;
	}

	public void setFunzione(String funzione) {
		this.funzione = funzione;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public List<Profili> getProfilis() {
		return this.profilis;
	}

	public void setProfilis(List<Profili> profilis) {
		this.profilis = profilis;
	}

}