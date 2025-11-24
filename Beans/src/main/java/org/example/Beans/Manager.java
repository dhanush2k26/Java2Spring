package org.example.Beans;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Manager implements Salary {

	public void show() {
		System.out.println("Hello Manager Bean");
	}
	@Override
	public void showSalary() {
		System.out.println("Salary is 80000");
		
	}

}
