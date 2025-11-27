package com.example.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beanfactory.IEmployeeFactory;
import com.example.model.ISalary;
import com.example.service.EmployeeService;

import java.util.Scanner;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        Scanner scanner = new Scanner(System.in);
        
        // Get services and factories from Spring container
        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
                
        // Set scanner in employee service
        employeeService.setScanner(scanner);
        
        IEmployeeFactory regularFactory = context.getBean("regularEmployeeFactory", IEmployeeFactory.class);
        IEmployeeFactory internFactory = context.getBean("internEmployeeFactory", IEmployeeFactory.class);
        IEmployeeFactory managerFactory=context.getBean("managerFactory",IEmployeeFactory.class);
        IEmployeeFactory partTimeFactory=context.getBean("partTimeEmployeeFactory",IEmployeeFactory.class);
        
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");
        System.out.println();
        
        // Get regular employees
        System.out.print("How many regular employees do you want to add? ");
        int regularCount = scanner.nextInt();
        scanner.nextLine();
        
        List<ISalary> regularEmployees = employeeService.createEmployees(regularFactory, regularCount);
        
        // Get intern employees
        System.out.print("How many intern employees do you want to add? ");
        int internCount = scanner.nextInt();
        scanner.nextLine();
        List<ISalary> internEmployees = employeeService.createEmployees(internFactory, internCount);
        
        System.out.print("How many manager do you want to add? ");
        int managerCount = scanner.nextInt();
        scanner.nextLine();
        
        List<ISalary> managers = employeeService.createEmployees(managerFactory, managerCount);
        System.out.print("How many Part Time Employees do you want to add? ");
        int partTimeCount = scanner.nextInt();
        scanner.nextLine();
        
        List<ISalary> partTimeEmployees = employeeService.createEmployees(partTimeFactory, partTimeCount);
        // Display all employees
        employeeService.displayAllEmployees(regularEmployees, internEmployees,managers,partTimeEmployees);
        
        scanner.close();
        ((AbstractApplicationContext) context).close();
    }
}