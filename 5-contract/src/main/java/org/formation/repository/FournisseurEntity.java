package org.formation.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openapitools.model.Fournisseur;

import lombok.Data;

@Entity
@Data
@Table(name="fournisseur")
public class FournisseurEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String reference;
	
	private String nom;
	
	Fournisseur getDto() {
		Fournisseur ret = new Fournisseur();
		ret.setId(id);
		ret.setNom(nom);
		ret.setReference(reference);
		return ret;
	}
}
