package com.api.employee.service;


import com.api.employee.domain.Employee;
import com.api.employee.exception.EmployeeApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    String insertEmployee(Employee employee) throws EmployeeApiException;

    Employee getEmployee(String id) throws EmployeeApiException;

    List<Employee> getAllEmployee() throws EmployeeApiException;

    String deleteEmployee(String id) throws EmployeeApiException;
}
