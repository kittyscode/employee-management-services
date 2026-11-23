package com.kd.employeemanagementservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}
