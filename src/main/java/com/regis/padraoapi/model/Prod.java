package com.regis.padraoapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long codiprod;
	private String dscrcomp;
	private String codibarr;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="marc_id")
	private Marc marc;

	public Prod() {
	}

	public Prod(Integer id, long codiprod, String dscrcomp, String codibarr, Marc marc) {
		super();
		this.id = id;
		this.codiprod = codiprod;
		this.dscrcomp = dscrcomp;
		this.codibarr = codibarr;
		this.marc = marc;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCodiprod() {
		return codiprod;
	}
	public void setCodiprod(long codiprod) {
		this.codiprod = codiprod;
	}
	public String getDscrcomp() {
		return dscrcomp;
	}
	public void setDscrcomp(String dscrcomp) {
		this.dscrcomp = dscrcomp;
	}
	public String getCodibarr() {
		return codibarr;
	}
	public void setCodibarr(String codibarr) {
		this.codibarr = codibarr;
	}
	public Marc getMarc() {
		return marc;
	}
	public void setMarc(Marc marc) {
		this.marc = marc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prod other = (Prod) obj;
		if (id != other.id)
			return false;
		return true;
	}

}