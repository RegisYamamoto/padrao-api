package com.regis.padraoapi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	String dirCampanhas = "C:/Workspace/padrao-api/uploaded";
	
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
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<?> processUploadFile(@RequestParam(value = "file") MultipartFile file) {
		File store = null;

		try {
			store = new File(dirCampanhas + "/" + file.getOriginalFilename());

			file.transferTo(store);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Object>(String.format(store.getAbsolutePath()), HttpStatus.OK);
	}
	
}