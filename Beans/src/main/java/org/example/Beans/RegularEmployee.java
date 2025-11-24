package org.example.Beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class RegularEmployee implements Salary {
	@Qualifier("regularEmployeeSalary")
	@Override
	public void showSalary() {
		System.out.println("Salary is 50000");
		
	}
	@Override
	public void show() {
		System.out.println("Hello Regular Employee Bean");		
	}
void display() {
		System.out.println("Hello Regular Employee Bean");
	}
}
