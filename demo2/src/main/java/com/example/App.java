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
     
     Employee emp = context.getBean(Employee.class);
     EmpAddress addr = context.getBean(EmpAddress.class);

     emp.setId(101);
     emp.setName("John Doe");
     emp.getEmpAddress().setCity("New York");
     emp.getEmpAddress().setState("NY");
     emp.getEmpAddress().setCountry("USA");

     if (emp.getEmpAddress() == null) {
         emp.setEmpAddress(addr);
     }

     System.out.println(emp);
    }
}
