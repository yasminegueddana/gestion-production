package tn.itbs.prod.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String competences;

    // Relations
    @ManyToOne
    @JoinColumn(name = "machineAssignee_id")
    private Machine machineAssignee;

    @OneToMany(mappedBy = "technicien")
    private List<Maintenance> maintenances;
    
    

}