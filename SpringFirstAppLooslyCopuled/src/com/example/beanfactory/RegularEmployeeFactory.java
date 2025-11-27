package com.example.beanfactory;

import com.example.model.ISalary;
import com.example.model.RegularEmployee;

public class RegularEmployeeFactory implements IEmployeeFactory {
    @Override
    public ISalary createEmployee() {
        return new RegularEmployee();
    }
    
    @Override
    public String getEmployeeType() {
        return "Regular Employee";
    }
}