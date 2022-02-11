package org.formation.rest.delegate;

import java.util.List;
import java.util.stream.Collectors;

import org.formation.repository.FournisseurRepository;
import org.formation.repository.ProduitRepository;
import org.openapitools.api.ProduitsApiDelegate;
import org.openapitools.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProduitRestDelegate implements ProduitsApiDelegate {

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	FournisseurRepository fournisseurRepository;



	@Override
	public ResponseEntity<List<Produit>> findAll() {
		// TODO Auto-generated method stub
		List<Produit> produits = produitRepository.findAll().stream().map(pe -> pe.getDto()).collect(Collectors.toList());
		return new ResponseEntity<List<Produit>>(produits,HttpStatus.OK);
	}



//	@GetMapping("/fournisseur/{fournisseurId}")
//	List<Produit> findByFournisseur(@PathVariable("fournisseurId") long fournisseurId) {
//
//		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId)
//				.orElseThrow(() -> new EntityNotFoundException("Fournisseur inconnu :" + fournisseurId));
//		return produitRepository.findByFournisseur(fournisseur);
//	}
//
//	@PostMapping
//	ResponseEntity<Produit> createProduct(@Valid @RequestBody Produit produit) {
//		
//		produit = produitRepository.save(produit);
//		
//		return new ResponseEntity<Produit>(produit,HttpStatus.CREATED);
//		
//	}
//	
//	@PostMapping("/addCSV")
//	ResponseEntity<ResultImportDto> addProducts(@RequestBody String csvFile) {
//
//		return new ResponseEntity<>(importProduitService.importLines(csvFile), HttpStatus.ACCEPTED);
//
//	}

}
