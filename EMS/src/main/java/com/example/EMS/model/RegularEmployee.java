package com.example.EMS.model;

import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RegularEmployee extends Employee {
	private int bonus;

	public RegularEmployee() {
	System.out.println("Regular Employee object Created");
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public void inputBasicSalary(Scanner s) {
		System.out.print("Enter the basic Salary:");
		this.basic_salary=s.nextInt();
		s.nextLine();
	}
	
	@Override
	public double calculateSalary() {
		return basic_salary+bonus;
	}
	
	@Override
	public void displayEmployeeInfo() {
		super.displayEmployeeInfo();
		System.out.print("Bonus:"+bonus+",Total Salary:"+String.format("%.2f", calculateSalary()));
	}



}
