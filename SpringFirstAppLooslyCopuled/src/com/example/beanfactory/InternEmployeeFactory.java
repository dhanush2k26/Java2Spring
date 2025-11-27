package com.example.beanfactory;

import com.example.model.ISalary;
import com.example.model.InternEmployee;

public class InternEmployeeFactory implements IEmployeeFactory {
    @Override
    public ISalary createEmployee() {
        return new InternEmployee();
    }
    
    @Override
    public String getEmployeeType() {
        return "Intern Employee";
    }
}