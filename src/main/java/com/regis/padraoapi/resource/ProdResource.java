package com.regis.padraoapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regis.padraoapi.model.Prod;
import com.regis.padraoapi.service.ProdService;

@RestController
@RequestMapping("/produtos")
public class ProdResource {
	
	@Autowired
	private ProdService prodService;

	@PostMapping("")
	public Prod cadastrarProduto(@RequestBody Prod prod) {
		return prodService.cadastrarProduto(prod);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prod> listarProdutoUnico(@PathVariable Integer id) {
		Prod prod = prodService.listarProdutoUnico(id);
		return ResponseEntity.ok().body(prod);
	}
	
}