package org.example.Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") 
public class Employee implements Salary {
	private int id;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
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
	private String name;
        void show() {
			System.out.println("Hello Employee Bean");
		}
		@Override
		public void showSalary() {
			System.out.println("Salary is 50000");
			
		}
}
