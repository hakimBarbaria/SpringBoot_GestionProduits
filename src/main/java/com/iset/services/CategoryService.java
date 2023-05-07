package com.iset.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iset.entities.Categorie;
import com.iset.entities.Produit;

public interface CategoryService {
	Categorie saveCategorie(Categorie c);
	 Page<Categorie> getAllCategoriesParPages(int page, int size);
	 
	 List<Categorie>getAllCategories();
	 
	 Categorie getCategorie(Long id);
	 Categorie updateCat(Categorie cat); 
	 
	 void deleteProduitById(Long id); 
	 
	 List<Categorie> findByNomCategorie(String nom);
}
