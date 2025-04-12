package tn.itbs.prod.services;

import java.util.List;
import tn.itbs.prod.models.OrdreFabrication;

public interface OrdreFabricationService {
    List<OrdreFabrication> getAllOrdreFabrications(); 
    OrdreFabrication getOrdreFabricationById(Long id);
    OrdreFabrication createOrdreFabrication(OrdreFabrication ordreFabrication);
    OrdreFabrication updateOrdreFabrication(OrdreFabrication ordreFabrication); 
    void deleteOrdreFabrication(Long id);
}