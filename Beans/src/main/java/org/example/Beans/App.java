package org.example.Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        Employee emp =  context.getBean(Employee.class);
        Employee emp2 =  context.getBean(Employee.class);
        emp.setId(101);
        emp.setName("John Doe");
        emp2.setId(102);
        emp2.setName("varun");
        System.out.println(emp.toString());
        System.out.println(emp2.toString());
        ((AnnotationConfigApplicationContext)context).close();
    }
}
