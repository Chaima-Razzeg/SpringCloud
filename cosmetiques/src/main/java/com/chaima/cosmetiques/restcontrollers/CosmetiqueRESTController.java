package com.chaima.cosmetiques.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.service.CosmetiqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CosmetiqueRESTController {
	
	@Autowired
	CosmetiqueService cosmetiqueService;
	
	 @RequestMapping(path="all",method =RequestMethod.GET)
	public List<Cosmetique> getAllCosmetiques()
	{
		return cosmetiqueService.getAllCosmetiques();
	}
	
	 @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Cosmetique getCosmetiqueById(@PathVariable("id") Long id) {
	     return cosmetiqueService.getCosmetique(id);
	 }
	 @RequestMapping(path="/addcosm",method = RequestMethod.POST)
	public Cosmetique createCosmetique(@RequestBody Cosmetique cosmetique) {
	     return cosmetiqueService.saveCosmetique(cosmetique);
	}
	
	 @RequestMapping(path="/updatecosm",method = RequestMethod.PUT)
	public Cosmetique updateCosmetique(@RequestBody Cosmetique cosmetique) {
	      return cosmetiqueService.updateCosmetique(cosmetique);
	}
	
	 @RequestMapping(value="/delcosm/{id}",method = RequestMethod.DELETE)
	public void deleteCosmetique(@PathVariable("id") Long id)
	{
	    cosmetiqueService.deleteCosmetiqueById(id);
	}
	 @RequestMapping(value="/cosmsray/{idRay}",method = RequestMethod.GET)
	public List<Cosmetique> getCosmetiquesByRayId(@PathVariable("idRay") Long idRay) {
	    return cosmetiqueService.findByRayonIdRay(idRay);
	}
	@RequestMapping(value="/cosmsByName/{nom}",method = RequestMethod.GET)
	public List<Cosmetique> findByNomCosmetiqueContains(@PathVariable("nom") String nom) {
	   return cosmetiqueService.findByNomCosmetiqueContains(nom);
	}



}
