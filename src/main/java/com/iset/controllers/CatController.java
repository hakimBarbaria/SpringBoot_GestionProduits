package com.iset.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iset.entities.Categorie;
import com.iset.entities.Produit;
import com.iset.services.CategoryService;
import com.iset.services.ProduitService;

@Controller
public class CatController {

	@Autowired
	private ProduitService produitService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/createCategory")
	public String createCategory(ModelMap modelMap) {
		modelMap.addAttribute("cat", new Categorie());
		return "createCategory";  
	}
	
	@RequestMapping("/saveCategory")
	public String saveCategory(Categorie cat,
			ModelMap modelMap
		   ) throws ParseException {
		
		Categorie savedCategory = categoryService.saveCategorie(cat);
		
		String msg = "categorie enregistré avec Id " + savedCategory.getIdCat();
		modelMap.addAttribute("msg", msg);

		return "redirect:/listeCategories";

	}
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		 List<Categorie> cats = categoryService.getAllCategories();
		modelMap.addAttribute("cats", cats);
		modelMap.addAttribute("produit", new Produit());
		return "createProduit";  
	}

	@RequestMapping("/saveProduit")
	public String saveProduit(@Valid Produit produit,
	 BindingResult bindingResult,
	 ModelMap modelMap) {

	 Produit saveProduit = produitService.saveProduit(produit);
	 String msg = "produit enregistré avec Id " +
	saveProduit.getIdProduit();
	 modelMap.addAttribute("msg", msg);
	 return "createProduit";
	 } 

	@RequestMapping("/ListeProduits")
	public String listeProduits(
	ModelMap modelMap,
	@RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "2") int size)
	{
	List<Categorie> categories = categoryService.getAllCategories();
	 Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
	modelMap.addAttribute("produits", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	  modelMap.addAttribute("categories", categories);
	return "listeProduits";
	} 

	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap
	modelMap,
	 @RequestParam(name = "page", defaultValue = "0") int page,
	 @RequestParam(name = "size", defaultValue = "2") int size) {
	 produitService.deleteProduitById(id);
	 Page<Produit> prods = produitService.getAllProduitsParPage(page,
	size);
	 modelMap.addAttribute("produits", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 modelMap.addAttribute("size", size);
	 return "listeProduits";
	 }

	
	
	@RequestMapping("/supprimerCat")
	public String supprimerCat(@RequestParam("id") Long id) {
	 categoryService.deleteProduitById(id);
	 return "redirect:/listeCategories";
	 }

	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap,
	                             @RequestParam(name = "page", defaultValue = "0") int page,
	                             @RequestParam(name = "size", defaultValue = "2") int size) {
	    Produit p = produitService.getProduit(id);
	    modelMap.addAttribute("produit", p);
	    modelMap.addAttribute("currentPage", page);
	    modelMap.addAttribute("size", size);
	    List<Categorie> cats = categoryService.getAllCategories();
		modelMap.addAttribute("cats", cats);
	    return "createProduit";
	}
	
	
	@RequestMapping("/modifierCategory")
	public String editerCat(@RequestParam("id") Long id, ModelMap modelMap
	                             ) {
	    Categorie cat = categoryService.getCategorie(id);
	    modelMap.addAttribute("cat", cat);
	    return "createCategory";
	}
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Produit produit,
	                             @RequestParam("dateCreation") String date,
	                             ModelMap modelMap,
	                             @RequestParam(name = "page", defaultValue = "0") int page,
	                             @RequestParam(name = "size", defaultValue = "2") int size) throws ParseException {
	    //conversion de la date
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateCreation = dateformat.parse(String.valueOf(date));
	    produit.setDateCreation(dateCreation);

	    produitService.updateProduit(produit);
	    Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
	    modelMap.addAttribute("produits", prods);
	    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	    modelMap.addAttribute("currentPage", page);
	    modelMap.addAttribute("size", size);

	    return "redirect:/listeProduits";
	}
	
	
	
	
	@RequestMapping("/updateCategory")
	public String updateCat(@ModelAttribute("cat") Categorie updatedCat) {
		if (updatedCat == null) {
			return "listeProduits";
		}
	    Categorie originalCat = categoryService.getCategorie(updatedCat.getIdCat());
	    originalCat.setIdCat(updatedCat.getIdCat());
	    originalCat.setNomCat(updatedCat.getNomCat());
	    originalCat.setDescriptionCat(updatedCat.getDescriptionCat());
	    categoryService.updateCat(originalCat);
	    return "redirect:/listeCategories";
	}

	@RequestMapping("listeCategories")
	public String listeCategories(ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		 Page<Categorie> cats = categoryService.getAllCategoriesParPages(page, size);
		modelMap.addAttribute("categories", cats);
		 modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		    modelMap.addAttribute("currentPage", page);
		    modelMap.addAttribute("size", size);
		return "listeCategories";
	}
	
	
	@PostMapping("/filter")
	public String filterProduit(
			ModelMap modelMap,
			@RequestParam("nomProduit") String nomProduit)
			{
			 List<Produit> prods = produitService.findByNomProduit(nomProduit);
			 if(prods.isEmpty()) {
				 modelMap.addAttribute("msg","Vous n'avez pas du produit avec ce nom !");
			 }else {
				 modelMap.addAttribute("produits", prods);
			 }
			
			return "listeProduits";
		} 
	
	@PostMapping("/filterWithCat")
	public String filterCat(
			ModelMap modelMap,
			@RequestParam("nomCat") String nomCat)
			{
			 List<Categorie> cats = categoryService.findByNomCategorie(nomCat);
			 if(cats.isEmpty()) {
				 modelMap.addAttribute("msg","Vous n'avez pas du produit avec ce nom !");
			 }else {
				 modelMap.addAttribute("categories", cats);
			 }
			
			return "listeCategories";
		} 
	
}

