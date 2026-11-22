package com.kd.employeemanagementservices.repository;

import com.kd.employeemanagementservices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
