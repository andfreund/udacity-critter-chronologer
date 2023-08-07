package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) throws UserNotFoundException {
        return employeeRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
