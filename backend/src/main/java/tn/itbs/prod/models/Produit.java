package tn.itbs.prod.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")  // Foreign key column
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fournisseur fournisseur;  // Reference to Fournisseur entity

    // Relations
    @OneToMany(mappedBy = "produit")
    private List<OrdreFabrication> ordres;
}