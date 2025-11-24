package org.example.Beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("InternSalary")
public class Intern implements  Salary {

	@Override
	public void showSalary() {
       System.out.println("16000");		
	}

	@Override
	public void show() {
	   System.out.println("Hello Intern Bean");		
	}

}
