package com.regis.padraoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regis.padraoapi.model.Marc;
import com.regis.padraoapi.repository.MarcRepository;
import com.regis.padraoapi.service.exception.ObjectNotFoundException;

@Service
public class MarcService {

	@Autowired
	private MarcRepository marcRepository;

	public Marc cadastrarMarca(Marc marc) {
		return marcRepository.save(marc);
	}
	
	public Marc listarMarcaUnica(Integer id) {
		Optional<Marc> marc = marcRepository.findById(id);
		return marc.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Marc.class.getName()));
	}
	
	public List<Marc> listarMarcas() {
		return marcRepository.findAll();
	}
	
}