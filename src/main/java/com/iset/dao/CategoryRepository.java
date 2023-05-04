package com.iset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.entities.Categorie;

public interface CategoryRepository extends JpaRepository<Categorie, Long>{

}
