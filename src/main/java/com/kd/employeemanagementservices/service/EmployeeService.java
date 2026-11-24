package com.kd.employeemanagementservices.service;

import com.kd.employeemanagementservices.entity.Employee;
import com.kd.employeemanagementservices.exception.EmployeeNotFoundException;
import com.kd.employeemanagementservices.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAll() {
        log.debug("Fetching all employees");
        return repository.findAll();
    }

    public Employee save(Employee employee) {

        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException("Name is Required");

        }

        if (employee.getSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative ");
        }

        log.info("Saving employee: {}", employee.getName());
        return repository.save(employee);
    }
    public Employee getById(Long id) {
        log.debug("Fetching employee with id: {}", id);
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee id not found - "+id));
    }



}

