package com.api.employee.service;

import com.api.employee.constants.Constants;
import com.api.employee.domain.Employee;
import com.api.employee.exception.EmployeeApiException;
import com.api.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String insertEmployee(Employee employee) throws EmployeeApiException {
        return employeeRepository.submitEnrollmentApplication(employee);
    }

    @Override
    public Employee getEmployee(String id) throws EmployeeApiException {

        List<Employee> employees;
        employees = employeeRepository.searchEmployee(id);

        if(!CollectionUtils.isEmpty(employees)){
            return employees.get(0);
        }else
            throw new EmployeeApiException(Constants.RECORD_NOT_FOUND,Constants.RECORD_NOT_FOUND_MSG,Constants.SOURCE);
    }

    @Override
    public List<Employee> getAllEmployee() throws EmployeeApiException {
        return employeeRepository.searchAllEmployee();
    }

    @Override
    public String deleteEmployee(String id) throws EmployeeApiException {
        return employeeRepository.deleteEmployee(id);
    }
}
