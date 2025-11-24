package com.dayone.demo;

public class Employee {
	private int id;
	private String name;
	private Salary salary;
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

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

	
	Employee(){
	 		System.out.println("Employee Object Created");	
	}

	@Override
	public String  toString() {
		return "Employee [id=" +getId() + ", name=" +getName() + "]";
	}

}
