package com.chaima.cosmetiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.chaima.cosmetiques.entities.Rayon;


@RepositoryRestResource(path = "ray")
@CrossOrigin("http://localhost:4200/") 
public interface RayonRepository extends JpaRepository<Rayon, Long> {

}
