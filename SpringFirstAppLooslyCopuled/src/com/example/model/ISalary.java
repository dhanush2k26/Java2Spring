package com.example.model;

public interface ISalary {
    double calculateSalary();
    void setEmployeeDetails(int id, String name, double basicSalary);
    void displayEmployeeInfo();
    String getEmployeeType();
}