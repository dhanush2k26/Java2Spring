package com.example.model;

public abstract class Employee implements ISalary {
    private int id;
    private String name;
    protected double basicSalary;
    
    // Default values
    private static final int DEFAULT_ID = 0;
    private static final String DEFAULT_NAME = "Unknown";
    private static final double DEFAULT_BASIC_SALARY = 20000.0; // Default basic salary
      

    @Override
    public void setEmployeeDetails(int id, String name, double basicSalary) {
        // Set ID with default if invalid
        this.id = (id > 0) ? id : DEFAULT_ID;
        
        // Set name with default if null or empty
        this.name = (name != null && !name.trim().isEmpty()) ? name.trim() : DEFAULT_NAME;
        
        // Set basic salary with default if invalid
        this.basicSalary = (basicSalary > 0) ? basicSalary : DEFAULT_BASIC_SALARY;
    }
    
    @Override
    public void displayEmployeeInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Basic Salary: " + basicSalary);
    }   

}