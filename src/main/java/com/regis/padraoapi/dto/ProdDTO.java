package com.regis.padraoapi.dto;

import java.io.Serializable;

import com.regis.padraoapi.model.Prod;

public class ProdDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long codiprod;
	private String dscrcomp;
	private String codibarr;
	private String mensagem;
	
	public ProdDTO() {
	}
	
	public ProdDTO(Prod prod) {
		id = prod.getId();
		codiprod = prod.getCodiprod();
		dscrcomp = prod.getDscrcomp();
		codibarr = prod.getCodibarr();
	}
	
	public ProdDTO(Prod prod, String mensagem) {
		id = prod.getId();
		codiprod = prod.getCodiprod();
		dscrcomp = prod.getDscrcomp();
		codibarr = prod.getCodibarr();
		this.mensagem = mensagem;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}