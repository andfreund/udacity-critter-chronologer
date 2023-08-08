package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
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

    public Set<Pet> findAllById(List<Long> petIds) {
        return new HashSet<>(petRepository.findAllById(new ArrayList<>(petIds)));
    }

    public List<Pet> getByOwnerId(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }
}
