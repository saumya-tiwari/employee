package com.api.employee.web.rest;

import com.api.employee.domain.Employee;
import com.api.employee.exception.EmployeeApiException;
import com.api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertEmployee(@RequestBody @Validated Employee employee, @PathVariable String applicationType)throws EmployeeApiException {
        String response;
        try{
            response = employeeService.insertEmployee(employee);
        }catch(EmployeeApiException apiEx) {
            throw apiEx;
        }catch(Exception ex) {
            throw ex;
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchEmployee(@PathVariable String id)throws EmployeeApiException {
        Employee employee;
        try{
            employee = employeeService.getEmployee(id);
        }catch(EmployeeApiException apiEx) {
            throw apiEx;
        }catch(Exception ex) {
            throw ex;
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAllEmployee()throws EmployeeApiException {
        List<Employee> employeeList;
        try{
            employeeList = employeeService.getAllEmployee();
        }catch(EmployeeApiException apiEx) {
            throw apiEx;
        }catch(Exception ex) {
            throw ex;
        }
        return ResponseEntity.ok(employeeList);
    }

    @DeleteMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteEmployee(@PathVariable String id)throws EmployeeApiException {
        Boolean result;
        try{
            result = employeeService.deleteEmployee(id);
        }catch(EmployeeApiException apiEx) {
            throw apiEx;
        }catch(Exception ex) {
            throw ex;
        }
        return ResponseEntity.ok(result);
    }

}
