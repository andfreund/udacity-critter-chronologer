package com.udacity.jdnd.course3.critter.pet;

import org.springframework.stereotype.Service;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


}
