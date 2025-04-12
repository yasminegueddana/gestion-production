package tn.itbs.prod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.prod.models.Produit;
import tn.itbs.prod.services.ProduitService;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
	@Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }
    
    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);

    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }

}
