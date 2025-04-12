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

import tn.itbs.prod.models.Maintenance;
import tn.itbs.prod.services.MaintenanceService;


@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {
	@Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.getAllMaintenances();
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.createMaintenance(maintenance);
    }
    
    @PutMapping("/{id}")
    public Maintenance update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
    	maintenance.setId(id); 
        return maintenanceService.updateMaintenance(id,maintenance);
    }

    @DeleteMapping("/{id}")
    public void createMaintenance(@PathVariable Long id) {
    	maintenanceService.deleteMaintenance(id);
    }

}
