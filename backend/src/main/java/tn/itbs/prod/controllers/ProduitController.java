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

import jakarta.persistence.EntityNotFoundException;
import tn.itbs.prod.models.Fournisseur;
import tn.itbs.prod.models.Produit;
import tn.itbs.prod.services.ProduitService;
import tn.itbs.prod.repositories.FournisseurRepository;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        System.out.println("Received Produit: " + produit);  // Debugging log
        if (produit.getFournisseur() != null && produit.getFournisseur().getId() != null) {
            Fournisseur fournisseur = fournisseurRepository.findById(produit.getFournisseur().getId())
                    .orElseThrow(() -> new RuntimeException("Fournisseur not found"));
            produit.setFournisseur(fournisseur);  // Ensure fournisseur is set
        }
        return produitService.createProduit(produit);
    }

    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        // Fetch and update the produit, ensure that fournisseur is set properly
        if (produit.getFournisseur() != null && produit.getFournisseur().getId() != null) {
            Fournisseur fournisseur = fournisseurRepository.findById(produit.getFournisseur().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Fournisseur not found"));
            produit.setFournisseur(fournisseur);
        }

        return produitService.updateProduit(id, produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}

