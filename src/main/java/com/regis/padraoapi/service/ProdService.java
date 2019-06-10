package com.regis.padraoapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.padraoapi.model.Prod;
import com.regis.padraoapi.repository.ProdRepository;

@Service
public class ProdService {

	@Autowired
	private ProdRepository prodRepository;
	
	public Prod cadastrarProduto(Prod prod) {
		return prodRepository.save(prod);
	}
	
	public Optional<Prod> listarProdutoUnico(Integer id) {
		Optional<Prod> prod = prodRepository.findById(id);
		return prod;
	}
	
}