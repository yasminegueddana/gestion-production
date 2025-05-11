package tn.itbs.prod.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String etat;
    private LocalDate maintenanceProchaine;

    // Relations
    @OneToMany(mappedBy = "machine")
    private List<OrdreFabrication> ordres;

    @OneToMany(mappedBy = "machineAssignee")
    private List<Technicien> techniciens;
}