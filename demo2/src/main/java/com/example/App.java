package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext context = new AnnotationConfigApplicationContext("com.example");
     
     // Retrieve beans and set sample values programmatically
     Employee emp = context.getBean(Employee.class);
     EmpAddress addr = context.getBean(EmpAddress.class);

     // Set employee values
     emp.setId(101);
     emp.setName("John Doe");
     emp.getEmpAddress().setCity("New York");
        emp.getEmpAddress().setState("NY");
        emp.getEmpAddress().setCountry("USA");

     // If autowiring is available, emp.empAddress should already be set, otherwise set it explicitly
     if (emp.getEmpAddress() == null) {
         emp.setEmpAddress(addr);
     }

     System.out.println(emp);
    }
}
