package com.chaima.cosmetiques.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rayon {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRay;
	private String nomRay;
	private String descriptionRay;
	
	@JsonIgnore
	@OneToMany (mappedBy ="rayon")
	private List<Cosmetique> cosmetiques;
	
	
	public Long getIdRay() {
		return idRay;
	}
	public void setIdRay(Long idRay) {
		this.idRay = idRay;
	}
	public String getNomRay() {
		return nomRay;
	}
	public void setNomRay(String nomRay) {
		this.nomRay = nomRay;
	}
	public String getDescriptionRay() {
		return descriptionRay;
	}
	public void setDescriptionRay(String descriptionRay) {
		this.descriptionRay = descriptionRay;
	}

	public List<Cosmetique> getCosmetiques() {
		return cosmetiques;
	}

	public void setCosmetiques(List<Cosmetique> cosmetiques) {
		this.cosmetiques = cosmetiques;
	}
	
	

}
