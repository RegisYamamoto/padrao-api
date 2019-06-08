package com.regis.padraoapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.regis.padraoapi.model.Marc;
import com.regis.padraoapi.model.Prod;
import com.regis.padraoapi.repository.MarcRepository;
import com.regis.padraoapi.repository.ProdRepository;

@SpringBootApplication
public class PadraoApiApplication implements CommandLineRunner {

	@Autowired
	private MarcRepository marcRepository;
	
	@Autowired
	private ProdRepository prodRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PadraoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Marc marc1 = new Marc(null, 4169, "TIROL");

		Prod p1 = new Prod(null, 158641, "REQUEIJAO TIROL TRADICIONAL 180 G", "7896294900712", marc1);
		Prod p2 = new Prod(null, 95522, "AZEITE ANDORINHA EXT VIRGEM VD 500 ML", "5601216120152", marc1);

		marc1.getProd().addAll(Arrays.asList(p1, p2));

		marcRepository.saveAll(Arrays.asList(marc1));
		prodRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
