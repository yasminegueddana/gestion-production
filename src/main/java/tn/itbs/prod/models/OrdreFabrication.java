package tn.itbs.prod.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class OrdreFabrication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private LocalDate date;
    private String statut;

    // Relations
    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Machine machine;
}