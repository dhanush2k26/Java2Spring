package com.example.EMS.model;

public abstract class Employee implements ISalary {
     private int id;
     private String name;
     protected double basic_salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic_salary() {
		return basic_salary;
	}
	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}
    @Override
    public void displayEmployeeInfo() {
    	System.out.print("Id:"+id+", Name:"+name+",Basic Salary:"+basic_salary+", ");
    }
}
