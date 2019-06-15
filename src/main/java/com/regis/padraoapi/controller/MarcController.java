package com.regis.padraoapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regis.padraoapi.dto.MarcDTO;
import com.regis.padraoapi.model.Marc;
import com.regis.padraoapi.service.MarcService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST padrão", tags = {"Marcas"})
@RestController
@RequestMapping("padraoapi/marcas")
public class MarcController {

	@Autowired
	private MarcService marcService;
	
	@ApiOperation(value="Cadastra uma marca")
	@PostMapping("")
	public Marc cadastrarMarca(@RequestBody Marc marc) {
		return marcService.cadastrarMarca(marc);
	}
	
	@ApiOperation(value="Retorna uma marca por id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Marc>> listarMarcaUnica(@PathVariable Integer id) {
		Optional<Marc> marc = marcService.listarMarcaUnica(id);
		return ResponseEntity.ok().body(marc);
	}
	
	@ApiOperation(value="Retorna uma lista com todas as mascas cadastradas")
	@GetMapping("")
	public ResponseEntity<List<MarcDTO>> listarMarcas() {
		List<Marc> list = marcService.listarMarcas();
		List<MarcDTO> listDto = list.stream().map(obj -> new MarcDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}