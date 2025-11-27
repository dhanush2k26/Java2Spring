package com.example.model;

public class Manager extends Employee {
    private double team_bonus;
    private int team_size;
    
    private static final double DEFAULT_TEAM_BONUS = 5000.0;
    private static final int DEFAULT_TEAM_SIZE = 5;
    
	public Manager() {
		System.out.println("Manager created");
	}

	public double getTeam_bonus() {
		return team_bonus;
	}

	public void setTeam_bonus(double team_bonus) {
		this.team_bonus = (team_bonus > 0) ? team_bonus : DEFAULT_TEAM_BONUS;
	}

	public int getTeam_size() {
		return team_size;
	}

	public void setTeam_size(int team_size) {
		this.team_size = (team_size > 0) ? team_size : DEFAULT_TEAM_SIZE;
	}

	@Override
	public double calculateSalary() {
		
		return basicSalary+team_bonus+(team_size*100);
	}
   @Override
public void displayEmployeeInfo() {
	super.displayEmployeeInfo();
	System.out.println("Employee Type: " + getEmployeeType());
	System.out.println("Team Bonus: " + team_bonus);
	System.out.println("Team Size: " + team_size);
	System.out.println("Total Salary: " + calculateSalary());
	System.out.println("------------------------");
}
	@Override
	public String getEmployeeType() {
	
		return "Manager";
	}


}
