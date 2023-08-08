package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findByEmployeeId(Long employeeId) {
        return scheduleRepository.findByEmployeesId(employeeId);
    }

    public List<Schedule> findByPetId(Long petId) {
        return scheduleRepository.findByPetsId(petId);
    }

    public List<Schedule> findByCustomerId(Long customerId) {
        return scheduleRepository.findByCustomerId(customerId);
    }
}
