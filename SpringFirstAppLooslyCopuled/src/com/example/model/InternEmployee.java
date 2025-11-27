package com.example.model;

public class InternEmployee extends Employee {
    public InternEmployee() {
        System.out.println("Intern Employee created");
    }   
    
    @Override
    public double calculateSalary() {
        return basicSalary;
    }
    
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Employee Type: " + getEmployeeType());
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("------------------------");
    }
    
    @Override
    public String getEmployeeType() {
        return "Intern Employee";
    }
}