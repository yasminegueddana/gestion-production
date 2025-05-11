package tn.itbs.prod.services;

import org.springframework.stereotype.Service;
import tn.itbs.prod.models.Fournisseur;
import tn.itbs.prod.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'ID : " + id));
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Long id, Fournisseur updatedFournisseur) {
        return fournisseurRepository.findById(id)
                .map(fournisseur -> {
                    fournisseur.setNom(updatedFournisseur.getNom());
                    fournisseur.setAdresse(updatedFournisseur.getAdresse());
                    fournisseur.setTelephone(updatedFournisseur.getTelephone());
                    return fournisseurRepository.save(fournisseur);
                })
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'ID : " + id));
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}