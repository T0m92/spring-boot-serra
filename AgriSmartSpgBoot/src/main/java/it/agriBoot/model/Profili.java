package it.agriBoot.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@NamedQuery(name="Profili.findAll", query="SELECT p FROM Profili p")
public class Profili implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idProf;

	private String consigli;

	private String descr;

	private Integer idConf;

	private String nome;

	
	//bi-directional many-to-one association to Config
	@OneToMany(mappedBy="profili", cascade = CascadeType.ALL) //fetch = FetchType.EAGER, 
	//@JsonIgnoreProperties({"profili"})
	@JsonIgnore
	private List<Config> configs;

	//bi-directional many-to-many association to Apparecchiature
	@ManyToMany
	@JsonIgnore
	@JoinTable(
		name="profappar"
		, joinColumns={
			@JoinColumn(name="idProfilo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="codAppar")
			}
		)
	
	private List<Apparecchiature> apparecchiatures;

	//bi-directional many-to-one association to Serra
	@ManyToOne
	//@JsonIgnoreProperties({"profili"})
	@JsonIgnore
	@JoinColumn(name="idSerra")
	private Serra serra;

	public Profili() {
	}

	public Integer getIdProf() {
		return this.idProf;
	}

	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}

	public String getConsigli() {
		return this.consigli;
	}

	public void setConsigli(String consigli) {
		this.consigli = consigli;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getIdConf() {
		return this.idConf;
	}

	public void setIdConf(Integer idConf) {
		this.idConf = idConf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Config> getConfigs() {
		return this.configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}

	public Config addConfig(Config config) {
		getConfigs().add(config);
		config.setProfili(this);

		return config;
	}

	public Config removeConfig(Config config) {
		getConfigs().remove(config);
		config.setProfili(null);

		return config;
	}

	public List<Apparecchiature> getApparecchiatures() {
		return this.apparecchiatures;
	}

	public void setApparecchiatures(List<Apparecchiature> apparecchiatures) {
		this.apparecchiatures = apparecchiatures;
	}

	public Serra getSerra() {
		return this.serra;
	}

	public void setSerra(Serra serra) {
		this.serra = serra;
	}

}