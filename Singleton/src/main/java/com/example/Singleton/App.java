package com.example.Singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      AnnotationConfigApplicationContext con= new AnnotationConfigApplicationContext(AppConfig.class);
      
      Bio bio=con.getBean(Bio.class);
      bio.setName("abr");
      bio.setAge(12);
      System.out.println(bio);
      Bio bio2=con.getBean(Bio.class);
//      bio2.setName("akash");
      bio2.setAge(3);
      System.out.println(bio2);
      System.out.println(bio);
    }
}
