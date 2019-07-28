package com.regis.padraoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.padraoapi.dto.ProdDTO;
import com.regis.padraoapi.model.Prod;
import com.regis.padraoapi.repository.ProdRepository;

@Service
public class ProdService {

	@Autowired
	private ProdRepository prodRepository;
	
	public Prod cadastrarProduto(Prod prod) {
		return prodRepository.save(prod);
	}
	
//	public Optional<Prod> listarProdutoUnico(Integer id) {
//		Optional<Prod> prod = prodRepository.findById(id);
//		return prod;
//	}
	
	public ProdDTO listarProdutoUnico(Integer id) {
		if (prodRepository.findById(id) != null) {
			return prodRepository.findById(id);
		} else {
			ProdDTO prodDto = new ProdDTO();
			prodDto.setMensagem("Produto inexistente");
			return prodDto;
		}
	}
	
}