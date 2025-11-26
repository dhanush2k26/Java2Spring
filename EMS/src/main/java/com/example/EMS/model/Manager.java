package com.example.EMS.model;

import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("Prototype")
public class Manager extends Employee {
	private int team_size;
	private double team_bonus;
	public Manager() {
		System.out.println("Manager object Created");
	}

	public int getTeam_size() {
		return team_size;
	}

	public void setTeam_size(int team_size) {
		this.team_size = team_size;
	}

	public double getTeam_bonus() {
		return team_bonus;
	}

	public void setTeam_bonus(double team_bonus) {
		this.team_bonus = team_bonus;
	}
	public void inputBasicSalary(Scanner s) {
		System.out.print("Enter the Basic Salary:");
		this.basic_salary=s.nextInt();
		s.nextLine();
	}
	public void inputTeamSize(Scanner s) {
		System.out.print("Enter the team size:");
		this.team_size=s.nextInt();
		s.nextLine();
	}
	public void inputTeamBounce(Scanner s) {
		System.out.print("Enter the team Bonus:");
		this.team_bonus=s.nextDouble();
		s.nextLine();
	}	

	@Override
	public double calculateSalary() {
		
		return basic_salary + (basic_salary+getTeam_bonus()+(team_size*100));
	}
	@Override
	public void displayEmployeeInfo() {
		super.displayEmployeeInfo();
		System.out.print("Team Size:"+team_size+",Team Bonus:"+team_bonus+",Total Salary:"+String.format("%.2f", calculateSalary()));
	}

}
