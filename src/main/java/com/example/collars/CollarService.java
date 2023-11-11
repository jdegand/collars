package com.example.collars;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollarService {
    private final CollarRepository collarRepository;

    public CollarService(CollarRepository collarRepository) {
        this.collarRepository = collarRepository;
    }

    public List<Collar> getCollars() {
        return collarRepository.findAll();
    }
    
    public Collar saveCollar(Collar collar) {
        return collarRepository.save(collar);
    }

    public Collar getByCollarId(CollarId collarId){
        return collarRepository.findByCollarId(collarId);
    }

    public List<Collar> findAllByCollarId_SerialId(Long serialId){
        return collarRepository.findAllByCollarId_SerialId(serialId);
    } 

    public List<Collar> findAllByCollarId_Pet(Pet pet){
        return collarRepository.findAllByCollarId_Pet(pet);
    } 

}
