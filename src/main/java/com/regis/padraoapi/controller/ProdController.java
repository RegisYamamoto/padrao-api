package com.regis.padraoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regis.padraoapi.dto.ProdDTO;
import com.regis.padraoapi.model.Prod;
import com.regis.padraoapi.service.ProdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST padrão", tags = {"Produtos"})
@RestController
@RequestMapping("padraoapi/produtos")
public class ProdController {
	
	@Autowired
	private ProdService prodService;

	@ApiOperation(value="Cadastra um produto")
	@PostMapping("")
	public Prod cadastrarProduto(@RequestBody Prod prod) {
		return prodService.cadastrarProduto(prod);
	}
	
	@ApiOperation(value="Cadastra um produto por id")
	@GetMapping("/{id}")
	public ResponseEntity<ProdDTO> listarProdutoUnico(@PathVariable Integer id) {
		ProdDTO prod = prodService.listarProdutoUnico(id);
		return ResponseEntity.ok().body(prod);
	}
	
	@ApiOperation(value="Listar todos os produtos")
	
	@GetMapping()
	public List<Prod> listarTodosOsProdutosa() {
		return prodService.listarTodosOsProdutos();
	}
	
}