package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String phoneNumber;

    private String notes;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;
}
