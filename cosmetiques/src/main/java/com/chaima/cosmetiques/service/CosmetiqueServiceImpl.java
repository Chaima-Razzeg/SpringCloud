package com.chaima.cosmetiques.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.entities.Rayon;
import com.chaima.cosmetiques.repos.CosmetiqueRepository;
import com.chaima.cosmetiques.repos.ImageRepository;

@Service
public class CosmetiqueServiceImpl implements CosmetiqueService {

    @Autowired
	CosmetiqueRepository cosmetiqueRepository;
    @Autowired
	ImageRepository imageRepository;
	
	
	@Override
	public Cosmetique saveCosmetique(Cosmetique c) {
		return cosmetiqueRepository.save(c);
	}

	@Override
	public Cosmetique updateCosmetique(Cosmetique p) {
	//Long oldCosmImageId =
	//this.getCosmetique(p.getIdCosmetique()).getImages().getIdImage();
	//Long newCosmImageId = p.getImage().getIdImage();
	Cosmetique cosmUpdated = cosmetiqueRepository.save(p);
	//if (oldCosmImageId != newCosmImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldCosmImageId);
	return cosmUpdated;
	}

	@Override
	public void deleteCosmetique(Cosmetique c) {
		cosmetiqueRepository.delete(c);
		
	}

	@Override
	public void deleteCosmetiqueById(Long id) {
	 Cosmetique p = getCosmetique(id);
	 //suuprimer l'image avant de supprimer le produit
	try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	} catch (IOException e) {
	e.printStackTrace();
	} 
	cosmetiqueRepository.deleteById(id);
	}
	@Override
	public Cosmetique getCosmetique(Long id) {
		return cosmetiqueRepository.findById(id).get();

	}

	@Override
	public List<Cosmetique> getAllCosmetiques() {
		return cosmetiqueRepository.findAll();
	}

	@Override
	public List<Cosmetique> findByNomCosmetique(String nom) {
		return cosmetiqueRepository.findByNomCosmetique(nom);
	}

	@Override
	public List<Cosmetique> findByNomCosmetiqueContains(String nom) {
		return cosmetiqueRepository.findByNomCosmetiqueContains(nom);
	}

	@Override
	public List<Cosmetique> findByNomPrix(String nom, Double prix) {
		return cosmetiqueRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Cosmetique> findByRayon(Rayon rayon) {
		return cosmetiqueRepository.findByRayon(rayon);
	}

	@Override
	public List<Cosmetique> findByRayonIdRay(Long id) {
		return cosmetiqueRepository.findByRayonIdRay(id);
	}

	@Override
	public List<Cosmetique> findByOrderByNomCosmetiqueAsc() {
		return cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
	}

	@Override
	public List<Cosmetique> trierCosmetiquesNomsPrix() {
		return cosmetiqueRepository.trierCosmetiquesNomsPrix();
	}

}
