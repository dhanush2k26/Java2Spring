package org.example.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") 

public class Employee {
	private int id;
	private String name;
	@Autowired
	@Qualifier("InternSalary")
	private Salary salary;
	public Salary getSalary() {
		return salary;
	}
	public void setSalary( Salary salary) {
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

	@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
}