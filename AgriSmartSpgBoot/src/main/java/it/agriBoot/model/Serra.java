package it.agriBoot.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@Entity
@Table (name="serra")
@NamedQueries({
//TUTTE le serre
@NamedQuery(name="Serra.findAll", query="SELECT s FROM Serra s"),
//trova la SERRA dal NOME
@NamedQuery(name="Serra.trovaNome", query="SELECT s FROM Serra s WHERE s.nome=:nome"),
//conta i PROFILI associati a una serra a partire dal NOME della SERRA
//(N.B.: da gestire l'eventualità che la query non trovi alcuna entry nel DB altrimenti si solleva un eccezione)
@NamedQuery(name="Serra.contaProfAssociati", query="SELECT new it.agriBoot.utils.SerraDTO(s.nome,s.id,COUNT(p)) FROM Serra s JOIN s.profilis p WHERE s.nome=:nome GROUP BY s.nome,s.id"),
//conta le CONFIGURAZIONI associate ad una serra a partire dal NOME della SERRA (passando per i profili..)
@NamedQuery(name="Serra.contaConfigAssociate", query="SELECT new it.agriBoot.utils.ProfiloDTO(s.id,s.nome,p.id,p.nome,COUNT(c)) FROM Serra s JOIN s.profilis p JOIN p.configs c WHERE s.nome=:nome GROUP BY s.id,s.nome"),                           

})


public class Serra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column (name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)//IDENTITY genera eccezione "hibernate-field-id-doesnt-have-a-default-value"
	private Integer id;
	
	@Column (name="nome")
	private String nome;

	//bi-directional many-to-one association to Profili
	@OneToMany(mappedBy="serra", cascade = CascadeType.ALL)// fetch = FetchType.EAGER,
	//@JsonIgnoreProperties({"serra"})
	@JsonIgnore
	private List<Profili> profilis;

	public Serra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Profili> getProfilis() {
		return this.profilis;
	}

	public void setProfilis(List<Profili> profilis) {
		this.profilis = profilis;
	}

	public Profili addProfili(Profili profili) {
		getProfilis().add(profili);
		profili.setSerra(this);

		return profili;
	}

	public Profili removeProfili(Profili profili) {
		getProfilis().remove(profili);
		profili.setSerra(null);

		return profili;
	}

}