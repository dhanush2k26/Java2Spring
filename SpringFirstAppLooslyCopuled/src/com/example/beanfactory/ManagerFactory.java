package com.example.beanfactory;

import com.example.model.ISalary;
import com.example.model.Manager;

public class ManagerFactory implements IEmployeeFactory {
	@Override
	public ISalary createEmployee() {
		return new Manager();
	}
	
	@Override
	public String getEmployeeType() {
		return "Manager";
	}

}
