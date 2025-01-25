package com.example.gestioncandidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
@EntityScan(basePackages = "com.example.gestioncandidat")
public class GestionCandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCandidatApplication.class, args);
	}

	@Autowired
	private CandidatRepo repository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
// save
			repository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
			repository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
			repository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));
			repository.save(new Candidat("Maroua", "dh", "maroua@esprit.tn"));
// fetch
			repository.findAll().forEach(System.out::println);

			//repository.candidatByNom(candidat.getNom(), Pageable.ofSize(1));
		};
	}

	;
}
