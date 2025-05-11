package tn.itbs.prod.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;
    private String telephone;
    
}