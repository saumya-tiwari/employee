package com.api.employee.repository;


import com.api.employee.constants.Constants;
import com.api.employee.domain.Employee;
import com.api.employee.exception.EmployeeApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {


    @Autowired
    @Lazy
    private MongoTemplate apiMongoTemplate;

    public String submitEnrollmentApplication(Employee employee) throws EmployeeApiException {
        try {
            apiMongoTemplate.save(employee, Constants.COLLECTION_NAME);
            return "INSERTED";
        }catch (Exception ex){
            throw new EmployeeApiException(Constants.MONG0_ERRORCODE,Constants.MONGO_EXCEPTION_MSG,Constants.SOURCE,ex);
        }
    }

    public List<Employee> searchEmployee(String id) throws EmployeeApiException {

        try {
            List<Employee> employees;
            Query query = new Query();
            query.addCriteria(Criteria.where(Constants.ID).is(id));
            employees = this.apiMongoTemplate.find(query, Employee.class, Constants.COLLECTION_NAME);
            return employees;
        } catch (Exception ex){
            throw new EmployeeApiException(Constants.MONG0_ERRORCODE,Constants.MONGO_EXCEPTION_MSG,Constants.SOURCE,ex);
        }

    }

    public List<Employee> searchAllEmployee() throws EmployeeApiException {

        try {
            List<Employee> employees;
            employees = this.apiMongoTemplate.findAll(Employee.class, Constants.COLLECTION_NAME);
            return employees;
        } catch (Exception ex){
            throw new EmployeeApiException(Constants.MONG0_ERRORCODE,Constants.MONGO_EXCEPTION_MSG,Constants.SOURCE,ex);
        }

    }

    public String deleteEmployee(String id) throws EmployeeApiException {

        try {
            Query query = new Query();
            query.addCriteria(Criteria.where(Constants.ID).is(id));
            this.apiMongoTemplate.findAllAndRemove(query, Constants.COLLECTION_NAME);
            return "deleted";
        } catch (Exception ex){
            throw new EmployeeApiException(Constants.MONG0_ERRORCODE,Constants.MONGO_EXCEPTION_MSG,Constants.SOURCE,ex);
        }

    }

}
