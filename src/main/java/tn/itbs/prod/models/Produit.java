package tn.itbs.prod.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private int stock;
    private String fournisseur;

    // Relations
    @OneToMany(mappedBy = "produit")
    private List<OrdreFabrication> ordres;
}