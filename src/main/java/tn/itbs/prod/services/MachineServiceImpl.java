package tn.itbs.prod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.prod.models.Machine;
import tn.itbs.prod.repositories.MachineRepository;

@Service
public class MachineServiceImpl  implements MachineService {
	@Autowired
    private MachineRepository machineRepository;

    @Override
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    @Override
    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine updateMachine(Long id, Machine machine) {
        machine.setId(id); 
        return machineRepository.save(machine);
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

}
