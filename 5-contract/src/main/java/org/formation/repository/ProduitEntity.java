package org.formation.repository;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openapitools.model.Produit;

import lombok.Data;

@Entity
@Data
@Table(name="produit")
public class ProduitEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String reference;
	
	private String nom;
	
	private String description;
	
	private Float prixUnitaire;
	
	private Integer availability;
	
	@Embedded
	private DimensionEntity dimension;
	
	@ManyToOne
	private FournisseurEntity fournisseur;
	
	public Produit getDto() {
		Produit ret = new Produit();
		ret.setId(id);
		ret.setReference(reference);
		ret.setNom(nom);
		ret.setDescription(description);
		ret.setPrixUnitaire(prixUnitaire);
		ret.setAvailability(availability);
		ret.setFournisseur(fournisseur.getDto());
		ret.setDimension(dimension.getDto());
		
		return ret;
	}
}
