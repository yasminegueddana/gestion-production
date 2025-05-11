package tn.itbs.prod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.prod.models.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
