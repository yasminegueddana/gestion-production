package tn.itbs.prod.services;

import java.util.List;

import tn.itbs.prod.models.Machine;

public interface MachineService {
	 List<Machine> getAllMachines();
	    Machine getMachineById(Long id);
	    Machine createMachine(Machine machine);
	    Machine updateMachine(Long id,Machine machine);
	    void deleteMachine(Long id);

}
