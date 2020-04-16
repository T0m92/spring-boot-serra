package it.agriBoot.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.agriBoot.utils.ConfigValue;


/**
 * The persistent class for the config database table.
 * 
 */
@Entity
@Table (name="config")
@JsonIgnoreProperties("profili")
@NamedQuery(name="Config.findAll", query="SELECT c FROM Config c")
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="idConf")
	@GeneratedValue(strategy=GenerationType.AUTO)//probabilmente da cambiare in AUTO
	private Integer idConf;
	
	@Column (name="parametri")
	private String parametri;
	
	@Transient //non è persistente
	@JsonIgnore //evita che nella response venga serializzato un attributo di tipo explodedConfig con valore null
	private List<ConfigValue> explodedConfig;

	//bi-directional many-to-one association to Profili
	@ManyToOne(cascade = CascadeType.ALL)//fetch = FetchType.EAGER
	
	//@JsonIgnoreProperties({"consigli", "descr", "idConf", "nome"})
	//@JsonIgnore
	@JoinColumn(name="idProf") 
	private Profili profili;

	public Config() {
	}

	public Integer getIdConf() {
		return this.idConf;
	}

	public void setIdConf(Integer idConf) {
		this.idConf = idConf;
	}

	public String getParametri() {
		return this.parametri;
	}

	public void setParametri(String parametri) {
		this.parametri = parametri;
	}
	
	public List<ConfigValue> getExplodedConfig() {
		return this.explodedConfig;
	}

	public void setExplodedConfig(List<ConfigValue> explodedConfig) {
		this.explodedConfig = explodedConfig;
	}

	public Profili getProfili() {
		return this.profili;
	}

	public void setProfili(Profili profili) {
		this.profili = profili;
	}

}