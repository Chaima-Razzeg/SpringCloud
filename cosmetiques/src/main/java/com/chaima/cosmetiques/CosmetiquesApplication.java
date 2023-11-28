package com.chaima.cosmetiques;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.entities.Rayon;

@SpringBootApplication
public class CosmetiquesApplication implements CommandLineRunner{

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CosmetiquesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Cosmetique.class,Rayon.class);
		
	}

}
