package com.kd.employeemanagementservices.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  //saglya controller chya error ithe yetil
public class EmployeeRestExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRestExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<EmployeeErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.warn("Bad request: {}", ex.getMessage());
        EmployeeErrorResponse body=new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> handleNotFound(EmployeeNotFoundException ex) {
        log.warn("Not found: {}",ex.getMessage());
         EmployeeErrorResponse body=new EmployeeErrorResponse(
                 HttpStatus.NOT_FOUND.value(),
                 ex.getMessage(),
                 System.currentTimeMillis());
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}
