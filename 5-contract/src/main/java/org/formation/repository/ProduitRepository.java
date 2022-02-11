package org.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long> {

	public List<ProduitEntity> findByFournisseur(FournisseurEntity fournisseur);
	
	Optional<ProduitEntity> findByReferenceAndFournisseur_Reference(String produitReference, String fournisseurReference);

}
