package com.iset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> { 
}
