package com.example.collars;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {

    private final CollarRepository collarRepository;
    private final PetRepository petRepository;

    public DBInitializer(CollarRepository collarRepository, PetRepository petRepository) {
        this.collarRepository = collarRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Sam");
        pet.setType("Bulldog");
        pet.setBirthDate(null);
        petRepository.save(pet);
        CollarId collarId = new CollarId();
        collarId.setPet(pet);
        collarId.setSerialId(1L);
        Collar collar = new Collar();
        collar.setCollarId(collarId);
        collar.setCollarMessage("This is Toby. If you found this dog, please call. +1-555-345-12-33");
        collarRepository.save(collar);

        //String petName = collar.getCollarId().getPet().getName();
        //System.out.println(petName);

        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Oscar");
        pet2.setType("English Terrier");
        pet2.setBirthDate(null);
        petRepository.save(pet2);
        CollarId collarId2 = new CollarId();
        collarId2.setPet(pet2);
        collarId2.setSerialId(2L);
        Collar collar2 = new Collar();
        collar2.setCollarId(collarId2);
        collar2.setCollarMessage("This is Jane. If you found this dog, please call. +1-555-355-25-83");
        collarRepository.save(collar2);

        // Add Pet without a collar -> test Collar Post
        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setName("Ace");
        pet3.setType("Poodle");
        pet3.setBirthDate(LocalDate.of(2014, 9, 11));
        petRepository.save(pet3);

    }
}