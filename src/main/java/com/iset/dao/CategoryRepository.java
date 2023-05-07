package com.iset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iset.entities.Categorie;
import com.iset.entities.Produit;

public interface CategoryRepository extends JpaRepository<Categorie, Long>{
	List<Categorie> findByNomCat(String nom);

	
}
