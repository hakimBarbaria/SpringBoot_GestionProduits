package com.iset; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date; 
import java.util.List; 
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest; 
import com.iset.dao.ProduitRepository;
import com.iset.entities.Categorie;
import com.iset.entities.Produit; 
@SpringBootTest
class ProduitsApplicationTests { 
	@Autowired
	private ProduitRepository produitRepository; 
	 
/*	@Test
	public void testCreateProduit() { 
	 Produit prod = new Produit("PC Asus",1500.500,new Date()); 
	produitRepository.save(prod); 
    } 
	@Test
	public void testFindProduit() 
	 { 
	 Produit p = produitRepository.findById(1L).get(); 
	 System.out.println(p); 
	 } 
	 
	@Test
	public void testUpdateProduit() 
	 { 
	 Produit p = produitRepository.findById(1L).get(); 
	p.setPrixProduit(2000.0); 
	produitRepository.save(p); 
	 
	 System.out.println(p); 
	 } 
	 
	@Test
	public void testDeleteProduit() 
	 { 
	 produitRepository.deleteById(1L);
	 }
	@Test
	public void testFindAllProduits() 
	 { 
	 List<Produit> prods = produitRepository.findAll(); 
	 
	 for (Produit p:prods) 
	 System.out.println(p); 
	 
	 } 
	
	@Test
	public void testFindByNomProduit() { 
		List<Produit> prods = produitRepository.findByNomProduit("iphone X");
		for (Produit p : prods) {
			System.out.println("testFindByNomProduit " + p.getNomProduit());
		}
	}
	
	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("Asus"); 
		for (Produit p : prods) {
			System.out.println(p.getNomProduit());       
		} 
	}
	
	@Test 
	public void testfindByNomPrix() { 
		List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
		for (Produit p : prods) {
			System.out.println("le produit est deja trouver \n"+p);       
			} 
		}
	
	
	
	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie(); 
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) { 
			System.out.println("La methode testfindByCategorie est comme resultat \n"+p);    
		} 
		if (prods.isEmpty()) {
			System.out.println("il n'exite aucun categorie \n");
		}
	}

	
	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) { 
			System.out.println("test find By Id de categorie" + p); 
			}
		}
	
	
	
	
	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) { 
			System.out.println("test FindByORDER "+p.getNomProduit() +" d'id "+ p.getIdProduit());
			}   
		}
	
	
	
	@Test
	public void testTrierProduitsNomsPrix() { 
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {    
			System.out.println("testTrierProduitsNomsPrix "+p.getNomProduit());    
			} 
		} 
	*/
	
	
	
	
} 