package com.chaima.cosmetiques.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.entities.Rayon;

@RepositoryRestResource(path="rest")
public interface CosmetiqueRepository extends JpaRepository<Cosmetique, Long> {

	List<Cosmetique> findByNomCosmetique(String nom);
	List<Cosmetique> findByNomCosmetiqueContains(String nom);
	
	/*@Query("select c from Cosmetique c where c.nomCosmetique like %?1 and c.prixCosmetique > ?2")
	List<Cosmetique> findByNomPrix (String nom, Double prix);*/

	@Query("select c from Cosmetique c where c.nomCosmetique like %:nom and c.prixCosmetique > :prix")
	List<Cosmetique> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
 
	@Query("select c from Cosmetique c where c.rayon = ?1")
	List<Cosmetique> findByRayon (Rayon rayon);
	
	List<Cosmetique> findByRayonIdRay(Long id);
	
	List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	
	@Query("select c from Cosmetique c order by c.nomCosmetique ASC,c.prixCosmetique DESC")
	List<Cosmetique> trierCosmetiquesNomsPrix ();



};
