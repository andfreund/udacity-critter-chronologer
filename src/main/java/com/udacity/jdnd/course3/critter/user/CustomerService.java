package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long ownerId) {
        return customerRepository.findById(ownerId).orElseThrow(UserNotFoundException::new);
    }

    public Customer getReferenceById(Long ownerId) {
        return customerRepository.getOne(ownerId);
    }
}
