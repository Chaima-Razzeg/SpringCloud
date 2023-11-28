package com.chaima.cosmetiques.service;

import java.util.List;

import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.entities.Rayon;

public interface CosmetiqueService {
	Cosmetique saveCosmetique(Cosmetique c);
	Cosmetique updateCosmetique(Cosmetique c);
	void deleteCosmetique(Cosmetique c);
	 void deleteCosmetiqueById(Long id);
	Cosmetique getCosmetique(Long id);
	List<Cosmetique> getAllCosmetiques();
	
	List<Cosmetique> findByNomCosmetique(String nom);
	List<Cosmetique> findByNomCosmetiqueContains(String nom);
	List<Cosmetique> findByNomPrix (String nom, Double prix);
	List<Cosmetique> findByRayon (Rayon rayon);
	List<Cosmetique> findByRayonIdRay(Long id);
	List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	List<Cosmetique> trierCosmetiquesNomsPrix();

	

}
