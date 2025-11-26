package com.example.EMS.model;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class PartTimeEmployee extends Employee {
	private double per_hour_salary;
	private int total_hour;

	
	public void inputBasicSalary(Scanner s) {
		System.out.print("Enter the basic Salary:");
		this.basic_salary=s.nextInt();
		s.nextLine();
	}
	public PartTimeEmployee() {
	   		System.out.println("Part Time Employee object Created");
	}
	public void inputPerHourSalary(Scanner s) {
		System.out.print("Enter the Per Hour Salary:");
		this.per_hour_salary=s.nextDouble();
		s.nextLine();
	}
	public void inputTotalHour(Scanner s) {
		System.out.print("Enter the Total hour:");
		this.total_hour=s.nextInt();
		s.nextLine();
	}
	
	
	@Override
	public double calculateSalary() {
		return basic_salary+(per_hour_salary*total_hour);
	}
	@Override
	public void displayEmployeeInfo() {
	
		super.displayEmployeeInfo();
		System.out.println("Per Hour Salary"+per_hour_salary+" ,Total hour"+total_hour+",Total Salary:"+String.format("%.2f", calculateSalary()));
	}

}
