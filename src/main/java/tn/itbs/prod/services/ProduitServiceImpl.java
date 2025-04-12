package tn.itbs.prod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.prod.models.Produit;
import tn.itbs.prod.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
    private ProduitRepository produitRepository;

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
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        produit.setId(id); 
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
	

}
