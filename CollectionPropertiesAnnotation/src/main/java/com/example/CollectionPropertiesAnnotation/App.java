package com.example.CollectionPropertiesAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(AppConfig.class);
      Triangle t=con.getBean(Triangle.class);
      System.out.println(t);
    }
}
