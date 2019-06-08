package com.regis.padraoapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Marc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private long codimarc;
	private String dscr;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCadastro;

	@OneToMany(mappedBy="marc")
	private List<Prod> prod = new ArrayList<>();

	public Marc() {
	}

	public Marc(Integer id, long codimarc, String dscr, Date dataCadastro) {
		super();
		this.id = id;
		this.codimarc = codimarc;
		this.dscr = dscr;
		this.dataCadastro = dataCadastro;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getCodimarc() {
		return codimarc;
	}
	public void setCodimarc(long codimarc) {
		this.codimarc = codimarc;
	}
	public String getDscr() {
		return dscr;
	}
	public void setDscr(String dscr) {
		this.dscr = dscr;
	}
	public List<Prod> getProd() {
		return prod;
	}
	public void setProd(List<Prod> prod) {
		this.prod = prod;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Marc other = (Marc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}