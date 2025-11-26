package com.example.EMS.model;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InternEmployee extends Employee {
	
	public InternEmployee() {
		System.out.println("Intern Employee object Created");
	}
	public void inputBasicSalary(Scanner s) {
		System.out.print("Enter the basic Salary:");
		this.basic_salary=s.nextInt();
		s.nextLine();
	}
	@Override
	public double calculateSalary() {
		
		return basic_salary;
	}
	@Override
	public void displayEmployeeInfo() {
		super.displayEmployeeInfo();
		System.out.print("Total Salary:"+String.format("%.2f", calculateSalary()));
	}

}
