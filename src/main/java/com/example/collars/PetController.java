package com.example.collars;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets(){
        return petService.getPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Integer id){
        return petService.getPetById(id);
    }

    @PostMapping
    public Pet savePet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }
    
}
