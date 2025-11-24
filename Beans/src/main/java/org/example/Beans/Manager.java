package org.example.Beans;

public class Manager implements Salary {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void show() {
		System.out.println("Hello Manager Bean");
	}
	@Override
	public void showSalary() {
		System.out.println("Salary is 80000");
		
	}

}
