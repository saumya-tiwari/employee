package com.api.employee.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class Employee {

    @JsonProperty("employeeId")
    private BigInteger employeeId;
    private String name;

    public BigInteger getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigInteger employeeId) {
        this.employeeId = employeeId;
    }

    private int age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
