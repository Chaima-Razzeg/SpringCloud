package com.chaima.cosmetiques.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.cosmetiques.entities.Rayon;
import com.chaima.cosmetiques.repos.RayonRepository;

@RestController
@RequestMapping("/api/ray")
@CrossOrigin("*")
public class RayonRESTController {
	@Autowired
	RayonRepository rayonRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Rayon> getAllRayons()
	{
	   return rayonRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Rayon getRayonById(@PathVariable("id") Long id) {
	   return rayonRepository.findById(id).get();
	}


}
