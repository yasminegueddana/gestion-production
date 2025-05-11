package tn.itbs.prod.services;

import java.util.List;

import tn.itbs.prod.models.Produit;

public interface ProduitService {
	List<Produit> getAllProduits();
    Produit getProduitById(Long id);
    Produit createProduit(Produit produit);
    Produit updateProduit(Long id, Produit produit);
    void deleteProduit(Long id);

}
