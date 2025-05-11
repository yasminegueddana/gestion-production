package tn.itbs.prod.services;

import java.util.List;

import tn.itbs.prod.models.Technicien;

public interface TechnicienService {
	 List<Technicien> getAllTechniciens();
	    Technicien getTechnicienById(Long id);
	    Technicien createTechnicien(Technicien technicien);
	    Technicien updateTechnicien(Long id, Technicien technicien);
	    void deleteTechnicien(Long id);

}
