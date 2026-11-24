package com.kd.employeemanagementservices.controller;

import com.kd.employeemanagementservices.entity.Employee;
import com.kd.employeemanagementservices.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        log.info("GET /employees called ");

        return  ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        log.info("POST /employees called ");
        Employee saved = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
       log.info("GET /employees/{}  called ", id);
        return ResponseEntity.ok(employeeService.getById(id));
    }


}
