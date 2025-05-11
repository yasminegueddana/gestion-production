package tn.itbs.prod.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.itbs.prod.models.Fournisseur;
import tn.itbs.prod.models.Produit;
import tn.itbs.prod.repositories.FournisseurRepository;
import tn.itbs.prod.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public Produit createProduit(Produit produit) {
        // Check if fournisseur is provided and valid
        if (produit.getFournisseur() != null && produit.getFournisseur().getId() != null) {
            Fournisseur fournisseur = fournisseurRepository.findById(produit.getFournisseur().getId())
                    .orElseThrow(() -> new RuntimeException("Fournisseur not found"));
            produit.setFournisseur(fournisseur);  // Ensure fournisseur is set
        }
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        // Ensure the produit exists before updating
        if (produitRepository.existsById(id)) {
            produit.setId(id); // Ensure the ID is set correctly
            if (produit.getFournisseur() != null && produit.getFournisseur().getId() != null) {
                Fournisseur fournisseur = fournisseurRepository.findById(produit.getFournisseur().getId())
                        .orElseThrow(() -> new RuntimeException("Fournisseur not found"));
                produit.setFournisseur(fournisseur);
            }
            return produitRepository.save(produit);
        } else {
            throw new RuntimeException("Produit not found for ID: " + id);
        }
    }

    @Override
    public void deleteProduit(Long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produit not found for ID: " + id);
        }
    }
}
