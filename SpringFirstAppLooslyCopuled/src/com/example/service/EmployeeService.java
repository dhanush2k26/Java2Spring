package com.example.service;

import java.util.Scanner;

import com.example.beanfactory.IEmployeeFactory;
import com.example.model.ISalary;
import com.example.model.RegularEmployee;

import java.util.List;
import java.util.ArrayList;

public class EmployeeService {
    private Scanner scanner;
    
    // Default constructor for Spring
    public EmployeeService() {
    }
    
    // Set scanner after creation
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public List<ISalary> createEmployees(IEmployeeFactory factory, int count) {
        List<ISalary> employees = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            System.out.println("ENTER DETAILS FOR " + factory.getEmployeeType() + " " + (i + 1) + ":");
            System.out.println("--------------------------------");
            
            ISalary employee = factory.createEmployee();
            
            // Get ID with validation
            int id = getValidatedIntInput("Enter Employee ID (or 0 for default): ", 0);
            
            // Get Name with validation
            System.out.print("Enter Employee Name (or press Enter for default): ");
            String name = scanner.nextLine();
            
            // Get Basic Salary with validation
            double basicSalary = getValidatedDoubleInput("Enter Basic Salary (or 0 for default): ", 0.0);
            
            employee.setEmployeeDetails(id, name, basicSalary);
            
            // Handle specific input for RegularEmployee
            if (employee instanceof RegularEmployee) {
                double bonus = getValidatedDoubleInput("Enter Bonus (or -1 for default): ", -1.0);
                ((RegularEmployee) employee).setBonus(bonus);
            }
            
            employees.add(employee);
            System.out.println(factory.getEmployeeType() + " Added Successfully!\n");
        }
        
        return employees;
    }
    
    // Helper method to get validated integer input
    private int getValidatedIntInput(String prompt, int invalidValue) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    return invalidValue; // Return the specified invalid value for empty input
                }
                
                int value = Integer.parseInt(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
    
    // Helper method to get validated double input
    private double getValidatedDoubleInput(String prompt, double invalidValue) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    return invalidValue; // Return the specified invalid value for empty input
                }
                
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    public void displayAllEmployees(List<ISalary> regularEmployees, List<ISalary> internEmployees, List<ISalary> manager,List<ISalary> partTimeEmployees) {
        System.out.println("\n=== ALL EMPLOYEE INFORMATION ===");
        System.out.println("================================\n");
        
        displayEmployeeList("REGULAR EMPLOYEES", regularEmployees);
        displayEmployeeList("INTERN EMPLOYEES", internEmployees);
        displayEmployeeList("MANAGER",manager);
        displayEmployeeList("PART TIME EMPLOYEES",partTimeEmployees);
        
        // Display summary
        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total Regular Employees: " + regularEmployees.size());
        System.out.println("Total Intern Employees: " + internEmployees.size());
        System.out.println("Total Managers: " + manager.size());
        System.out.println("Total Part Time Employees: " + partTimeEmployees.size());
        System.out.println("Total Employees: " + (regularEmployees.size() + internEmployees.size() + manager.size()+partTimeEmployees.size()));
    }
    
    private void displayEmployeeList(String title, List<ISalary> employees) {
        if (!employees.isEmpty()) {
            System.out.println(title + ":");
            System.out.println("==================");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i).getEmployeeType() + " " + (i + 1) + ":");
                employees.get(i).displayEmployeeInfo();
            }
        } else {
            System.out.println("No " + title + " added.");
        }
    }
}