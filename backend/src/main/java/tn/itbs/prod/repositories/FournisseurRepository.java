package tn.itbs.prod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.prod.models.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}