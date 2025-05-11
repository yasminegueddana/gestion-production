package tn.itbs.prod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.prod.models.Technicien;
import tn.itbs.prod.services.TechnicienService;




@RestController
@RequestMapping("/api/techniciens")
public class TechnicienController {
	@Autowired
    private TechnicienService technicienService;

    @GetMapping
    public List<Technicien> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    @PostMapping
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.createTechnicien(technicien);
    }
    
    @PutMapping("/{id}")
    public Technicien update(@PathVariable Long id, @RequestBody Technicien technicien) {
        return technicienService.updateTechnicien(id, technicien);

    }

    @DeleteMapping("/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
    	technicienService.deleteTechnicien(id);
    }

}
