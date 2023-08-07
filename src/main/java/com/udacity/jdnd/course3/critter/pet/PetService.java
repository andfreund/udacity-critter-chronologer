package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public Pet save(Pet pet) {
        Pet returnedPet = petRepository.save(pet);
        Customer customer = returnedPet.getOwner();
        customer.addPet(returnedPet);
        customerRepository.save(customer);

        return returnedPet;
    }

    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    }

    public List<Pet> findAllById(List<Long> petIds) {
        return petRepository.findAllById(petIds);
    }

    public List<Pet> getByOwnerId(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }
}
