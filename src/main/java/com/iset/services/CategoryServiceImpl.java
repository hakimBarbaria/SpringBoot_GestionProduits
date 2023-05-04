package com.iset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iset.dao.CategoryRepository;
import com.iset.entities.Categorie;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public Categorie saveCategorie(Categorie c) {
		return categoryRepository.save(c);
	}
	@Override
	public List<Categorie> getAllCategories() {
		return categoryRepository.findAll();
	}

}
