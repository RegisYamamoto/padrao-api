package com.regis.padraoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.regis.padraoapi.dto.ProdDTO;
import com.regis.padraoapi.model.Prod;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Long> {

	@Query(value = "SELECT p FROM Prod p WHERE p.id = ?1")
	ProdDTO findById(long id);
	
}