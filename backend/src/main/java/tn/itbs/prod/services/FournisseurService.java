package tn.itbs.prod.services;

import tn.itbs.prod.models.Fournisseur;
import java.util.List;


public interface FournisseurService {
    List<Fournisseur> getAllFournisseurs();
    Fournisseur getFournisseurById(Long id);
    Fournisseur createFournisseur(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Long id, Fournisseur updatedFournisseur);
    void deleteFournisseur(Long id);
}