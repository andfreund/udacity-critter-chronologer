package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private PetType petType;

    private String name;

    @ManyToOne
    private Customer owner;

    private LocalDate birthDate;

    private String notes;
}
