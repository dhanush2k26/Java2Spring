package com.example.model;

public class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private int hoursWorked;
	
    private static final double HOURLY_WAGE_DEFAULT = 40.0;
    private static final int HOURS_WORKED_DEFAULT = 80;


	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = (hourlyWage > 0) ? hourlyWage : HOURLY_WAGE_DEFAULT;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = (hoursWorked > 0) ? hoursWorked : HOURS_WORKED_DEFAULT;
	}
	@Override
	public double calculateSalary() {
		
		return basicSalary+(hourlyWage * hoursWorked);
	}

	@Override
	public void displayEmployeeInfo() {
		// TODO Auto-generated method stub
		super.displayEmployeeInfo();
		System.out.println("Employee Type: " + getEmployeeType());
		System.out.println("Hourly Wage: " + hourlyWage);
		System.out.println("Hours Worked: " + hoursWorked);
		System.out.println("Total Salary: " + calculateSalary());
		System.out.println("------------------------");
	}
	@Override
	public String getEmployeeType() {
		  return "PartTime Employee";
	}

}
