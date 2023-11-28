package com.chaima.cosmetiques.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Cosmetique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCosmetique;
	private String nomCosmetique;
	private Double prixCosmetique;
	private Date dateCreation;
	private String imagePath;

	@OneToMany (mappedBy = "cosmetique")
	 private List<Image> images;

	
	@ManyToOne
	private Rayon rayon;
	
	
	
	public Cosmetique() {
		super();
	}
	
	













	public Cosmetique(Long idCosmetique, String nomCosmetique, Double prixCosmetique, Date dateCreation,
			String imagePath, List<Image> images, Rayon rayon) {
		super();
		this.idCosmetique = idCosmetique;
		this.nomCosmetique = nomCosmetique;
		this.prixCosmetique = prixCosmetique;
		this.dateCreation = dateCreation;
		this.imagePath = imagePath;
		this.images = images;
		this.rayon = rayon;
	}















	public Long getIdCosmetique() {
		return idCosmetique;
	}
	public void setIdCosmetique(Long idCosmetique) {
		this.idCosmetique = idCosmetique;
	}
	public String getNomCosmetique() {
		return nomCosmetique;
	}
	public void setNomCosmetique(String nomCosmetique) {
		this.nomCosmetique = nomCosmetique;
	}
	public Double getPrixCosmetique() {
		return prixCosmetique;
	}
	public void setPrixCosmetique(Double prixCosmetique) {
		this.prixCosmetique = prixCosmetique;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}







	public List<Image> getImages() {
		return images;
	}







	public void setImages(List<Image> images) {
		this.images = images;
	}







	public String getImagePath() {
		return imagePath;
	}







	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}







	@Override
	public String toString() {
		return "Cosmetique [idCosmetique=" + idCosmetique + ", nomCosmetique=" + nomCosmetique + ", prixCosmetique="
				+ prixCosmetique + ", dateCreation=" + dateCreation + ", images=" + images + ", rayon=" + rayon + "]";
	}


	
	
	

}
