package org.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<FournisseurEntity, Long> {

	Optional<FournisseurEntity> findByReference(String reference);
	
	
}
