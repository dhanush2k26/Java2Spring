package com.dayone.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       Employee emp = (Employee) context.getBean("emp");
       System.out.println(emp.toString());
       emp.getSalary().ShowSalary();
    }
}
