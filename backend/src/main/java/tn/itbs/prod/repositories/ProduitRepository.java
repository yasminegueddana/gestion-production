package tn.itbs.prod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.prod.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
