package com.example.collars;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collars")
public class CollarController {

    private CollarService collarService;

    public CollarController(CollarService collarService) {
        this.collarService = collarService;
    }

    @GetMapping
    public List<Collar> getCollars(){
        return collarService.getCollars();
    }

    @GetMapping("/serialId/{serialId}/petId/{pet}")
    public Collar findByCollarId(@PathVariable Long serialId, @PathVariable Pet pet){
        CollarId collarId = new CollarId(serialId, pet);
        return collarService.getByCollarId(collarId);
    }

    @GetMapping("/serialId/{serialId}")
    public List<Collar> findAllByCollarId_SerialId(@PathVariable Long serialId){
        return collarService.findAllByCollarId_SerialId(serialId);
    }

    @GetMapping("/petId/{pet}")
    public List<Collar> findAllByCollarId_Pet(@PathVariable Pet pet){ 
        return collarService.findAllByCollarId_Pet(pet);
    }

    @PostMapping
    public Collar saveCollar(@RequestBody Collar collar){

        // need to add serialId and petId to PostMapping? 
        // @PostMapping("/serialId/{serialId}/petId/{pet}")?
        // I think so -> need serial id and pet to POST a new collar object 
        // petId -> need to perform a findByPetId to get whole pet info to add to the Collar object?
        // In frontend/backend, you have to create the composite key and add the form value for collarMessage 

        return collarService.saveCollar(collar);
    }

}
