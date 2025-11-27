package com.example.beanfactory;

import com.example.model.ISalary;
import com.example.model.PartTimeEmployee;

public class PartTimeEmployeeFactory implements IEmployeeFactory {
    @Override
    public ISalary createEmployee() {
     return new PartTimeEmployee();
    }
	
	@Override
	public String getEmployeeType() {
		return "Part Time Employee";
	}

}
