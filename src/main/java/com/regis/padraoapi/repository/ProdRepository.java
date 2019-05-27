package com.regis.padraoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.regis.padraoapi.model.Prod;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Integer> {

}