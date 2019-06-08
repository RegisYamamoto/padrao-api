package com.regis.padraoapi.resource;

import java.util.List;
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

@RestController
@RequestMapping("/marcas")
public class MarcResource {

	@Autowired
	private MarcService marcService;
	
	@PostMapping("")
	public Marc cadastrarMarca(@RequestBody Marc marc) {
		return marcService.cadastrarMarca(marc);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Marc> listarMarcaUnica(@PathVariable Integer id) {
		Marc marc = marcService.listarMarcaUnica(id);
		return ResponseEntity.ok().body(marc);
	}
	
	@GetMapping("")
	public ResponseEntity<List<MarcDTO>> findAll() {
		List<Marc> list = marcService.findAll();
		List<MarcDTO> listDto = list.stream().map(obj -> new MarcDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}