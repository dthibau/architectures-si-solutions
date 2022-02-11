package org.formation.repository;

import javax.persistence.Embeddable;

import org.openapitools.model.Dimension;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class DimensionEntity {

	private float hauteur,longueur,largeur;

	@Override
	public String toString() {
	
		return largeur+" x "+longueur+" x "+hauteur;
	}
	
	public Dimension getDto() {
		Dimension ret = new Dimension();
		ret.setHauteur(hauteur);
		ret.setLargeur(largeur);
		ret.setLongueur(longueur);
		
		return ret;
	}
}
