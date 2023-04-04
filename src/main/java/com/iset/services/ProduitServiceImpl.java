package com.iset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iset.dao.ProduitRepository;
import com.iset.entities.Categorie;
import com.iset.entities.Produit;

@Service
public class ProduitServiceImpl implements ProduitService{ 
@Autowired
 ProduitRepository produitRepository; 
 
@Override
public Produit saveProduit(Produit p) { 
 return produitRepository.save(p); 
 } 
@Override
public Produit updateProduit(Produit p) { 
 return produitRepository.save(p); 
 } 
@Override
public void deleteProduit(Produit p) { 
 produitRepository.delete(p); 
 
 } 
@Override
public void deleteProduitById(Long id) { 
 produitRepository.deleteById(id); 
}
@Override
public Produit getProduit(Long id) { 
 return produitRepository.findById(id).get(); 
 } 
@Override
public List<Produit> getAllProduits() { 
 
 return produitRepository.findAll(); 
 } 
@Override
public Page<Produit> getAllProduitsParPage(int page, int size) {
 // TODO Auto-generated method stub
 return produitRepository.findAll(PageRequest.of(page, size));
 }


public List<Produit> findByNomProduit(String nom) {
	return produitRepository.findByNomProduit(nom);
}

public List<Produit> findByNomProduitContains(String nom) {
	return produitRepository.findByNomProduitContains(nom);
}

public List<Produit> findByNomPrix (String nom, Double prix) {
	return produitRepository.findByNomPrix(nom, prix);
}
public List<Produit> findByCategorie (Categorie categorie) {
	return produitRepository.findByCategorie(categorie);
}

public List<Produit> findByCategorieIdCat(Long id) {
	return produitRepository.findByCategorieIdCat(id);
}

public List<Produit> findByOrderByNomProduitAsc() {
	return produitRepository.findByOrderByNomProduitAsc();
}

public List<Produit> trierProduitsNomsPrix() {
	return produitRepository.trierProduitsNomsPrix();
}

}