package com.iset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iset.dao.CategoryRepository;
import com.iset.entities.Categorie;
import com.iset.entities.Produit;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public Categorie saveCategorie(Categorie c) {
		return categoryRepository.save(c);
	}
	@Override
	public Categorie getCategorie(Long id) {
		return categoryRepository.findById(id).get();
	}
	@Override
	public Categorie updateCat(Categorie cat) {
		return categoryRepository.save(cat);
	}
	@Override
	public void deleteCategorieById(Long id) {
		categoryRepository.deleteById(id); 
		
	}
	@Override
	public Page<Categorie> getAllCategoriesParPages(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Categorie> getAllCategories() {
		return categoryRepository.findAll();
	}
	@Override
	public List<Categorie> findByNomCategorie(String nom) {
		return categoryRepository.findByNomCat(nom);
	}

}
