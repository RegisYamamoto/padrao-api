package com.regis.padraoapi.dto;

import java.io.Serializable;

import com.regis.padraoapi.model.Marc;

public class MarcDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private long codimarc;
	private String dscr;
	
	public MarcDTO() {
	}
	
	public MarcDTO(Marc marc) {
		id = marc.getId();
		codimarc = marc.getCodimarc();
		dscr = marc.getDscr();
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
	
}