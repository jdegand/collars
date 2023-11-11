package com.example.collars;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class CollarId implements Serializable {

    @Column(nullable = false) 
    private Long serialId; 

    @OneToOne(optional = false) 
    @JoinColumn(name = "pet_id", nullable = false) 
    private Pet pet;

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // JPA buddy article doesn't mention constructors 
    // according to https://www.baeldung.com/jpa-composite-primary-keys
    // a no args constructor is required

    public CollarId(Long serialId, Pet pet) {
        this.serialId = serialId;
        this.pet = pet;
    }

    public CollarId() {
    }
    
}
