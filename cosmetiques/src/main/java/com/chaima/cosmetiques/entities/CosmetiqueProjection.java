package com.chaima.cosmetiques.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomCosm", types = { Cosmetique.class })
public interface CosmetiqueProjection {
	public String getNomCosmetique();

   
}
