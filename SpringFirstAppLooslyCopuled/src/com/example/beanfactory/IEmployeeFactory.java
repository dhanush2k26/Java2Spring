package com.example.beanfactory;

import com.example.model.ISalary;

public interface IEmployeeFactory {
    ISalary createEmployee();
    String getEmployeeType();
}