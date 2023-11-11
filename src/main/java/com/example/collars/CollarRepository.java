package com.example.collars;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollarRepository extends JpaRepository<Collar, CollarId> {
    Collar findByCollarId(CollarId collarId); 

    List<Collar> findAllByCollarId_SerialId(Long serialId); 

    List<Collar> findAllByCollarId_Pet(Pet pet); 
}
