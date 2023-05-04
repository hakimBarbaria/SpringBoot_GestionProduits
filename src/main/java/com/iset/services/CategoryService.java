package com.iset.services;

import java.util.List;

import com.iset.entities.Categorie;

public interface CategoryService {
	Categorie saveCategorie(Categorie c);
	 List<Categorie> getAllCategories();
}
