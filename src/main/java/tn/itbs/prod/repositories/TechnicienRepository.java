package tn.itbs.prod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.prod.models.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

}
