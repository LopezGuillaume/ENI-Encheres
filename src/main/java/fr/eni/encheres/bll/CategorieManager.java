package fr.eni.encheres.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dao.CategorieRepository;

@Component
public class CategorieManager {
	
	@Autowired
	CategorieRepository categorieRep; 
	
	public Categorie ajouterCategorie(String libelle) throws Exception {
		Categorie categorie = null; 
		try {
			categorie = new Categorie(libelle) ; 
			categorie = categorieRep.save(categorie) ; 
		} catch (Exception e) {
			throw e;
		}
		return categorie;	
	}
	
	public List<Categorie> selectionnerCategorieById(Long noCategorie) throws Exception {
		List<Categorie> listCategorie = (List<Categorie>) categorieRep.findByNoCategorie(noCategorie);
		return listCategorie;		
	}
	
	public Categorie selectionnerCategorie(Long noCategorie) throws Exception {
		Categorie categorie = null;
		try {
			categorie = categorieRep.findOneByNoCategorie(noCategorie);
		} catch (Exception e) {
			throw e;
		}
		return categorie;
	}

	public Iterable<Categorie> selectionnerTous() {
		Iterable<Categorie> list = categorieRep.findAll();
		return list;
	}
	
}
