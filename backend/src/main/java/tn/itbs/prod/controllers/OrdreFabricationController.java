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

import tn.itbs.prod.models.OrdreFabrication;
import tn.itbs.prod.services.OrdreFabricationService;

@RestController
@RequestMapping("/api/ordrefabrications")

public class OrdreFabricationController {
	
	@Autowired
    private OrdreFabricationService ordrefabricationService;

    @GetMapping
    public List<OrdreFabrication> getAllOrdreFabrications() {
        return ordrefabricationService.getAllOrdreFabrications();
    }

    @PostMapping
    public OrdreFabrication createOrdreFabrication(@RequestBody OrdreFabrication ordrefabrication) {
        return ordrefabricationService.createOrdreFabrication(ordrefabrication);
    }
    
    @PutMapping("/{id}")
    public OrdreFabrication update(@PathVariable Long id, @RequestBody OrdreFabrication ordrefabrication) {
    	ordrefabrication.setId(id); 
        return ordrefabricationService.updateOrdreFabrication(ordrefabrication);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdreFabrication(@PathVariable Long id) {
    	 ordrefabricationService.deleteOrdreFabrication(id);
    }

}
