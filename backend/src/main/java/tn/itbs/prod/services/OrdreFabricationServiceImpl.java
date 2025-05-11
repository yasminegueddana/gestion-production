package tn.itbs.prod.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.itbs.prod.models.OrdreFabrication;
import tn.itbs.prod.repositories.OrdreFabricationRepository;

@Service
public class OrdreFabricationServiceImpl implements OrdreFabricationService {

    @Autowired
    private OrdreFabricationRepository ordreFabricationRepository;

    @Override
    public List<OrdreFabrication> getAllOrdreFabrications() {
        return ordreFabricationRepository.findAll();
    }

    @Override
    public OrdreFabrication getOrdreFabricationById(Long id) {
        return ordreFabricationRepository.findById(id).orElse(null);
    }

    @Override
    public OrdreFabrication createOrdreFabrication(OrdreFabrication ordreFabrication) {
        return ordreFabricationRepository.save(ordreFabrication);
    }

    @Override
    public OrdreFabrication updateOrdreFabrication(OrdreFabrication ordreFabrication) {
        return ordreFabricationRepository.save(ordreFabrication);
    }

    @Override
    public void deleteOrdreFabrication(Long id) {
        ordreFabricationRepository.deleteById(id);
    }
}