package org.example.Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        Employee emp1 = context.getBean(Employee.class);
        emp1.setId(1);
        emp1.setName("John Doe");
        System.out.println(emp1.toString());
        emp1.getSalary().show();
        emp1.getSalary().showSalary();
        Employee  emp2 = context.getBean(Employee.class);
        emp2.setId(2);
        emp2.setName("Jane varun");
        System.out.println(emp2.toString());
        emp2.getSalary().show();
        emp1.getSalary().showSalary();

        ((AnnotationConfigApplicationContext)context).close();
    }
}