package com.regis.padraoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.regis.padraoapi.model.Marc;

@Repository
public interface MarcRepository extends JpaRepository<Marc, Integer> {

}