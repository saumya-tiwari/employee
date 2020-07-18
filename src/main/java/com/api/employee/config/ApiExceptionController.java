package com.api.employee.config;

import com.api.employee.exception.EmployeeApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionController {
    @ExceptionHandler(value = EmployeeApiException.class)
    public ResponseEntity<Object> exception(EmployeeApiException exception) {
        return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
    }
}
