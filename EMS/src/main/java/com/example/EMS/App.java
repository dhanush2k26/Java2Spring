package com.example.EMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.AppConfig;
import com.example.EMS.model.InternEmployee;
import com.example.EMS.model.Manager;
import com.example.EMS.model.PartTimeEmployee;
import com.example.EMS.model.RegularEmployee;
public class App 
{ 

    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(AppConfig.class);
       Scanner sc=new Scanner(System.in);
       System.out.println("-----Employee Info Dashboard-----");

       List<RegularEmployee> regEmpList=new ArrayList<>();
       List<InternEmployee> internEmpList=new ArrayList<>();
       List<PartTimeEmployee> partTimeEmpList=new ArrayList<>();
       List<Manager> managerList=new ArrayList<>();
       String flag="yes";
       while(flag.equalsIgnoreCase("yes")){
    	   
    	   System.out.println("-----Menu-----");
    	   System.out.println("1.Insert Regular Employee  Record");
    	   System.out.println("2.Insert Intern Employee Record");
    	   System.out.println("3.Insert Part Time Employee Record");
    	   System.out.println("4.Insert Manager Record");
    	   System.out.println("5.View All Regular Employee  Record with Regular Employees Total size");
    	   System.out.println("6.View All Intern Employee  Record with Intern Employees Total size ");
    	   System.out.println("7.View All Part Time Employee  Record with Part Time Employees Total size");
    	   System.out.println("8.View All Manager Employee  Record with Manager Total size");
    	   System.out.println("9.Total Count of All Employee");
           System.out.println("10.Exit");
           System.out.print("Enter your choice:");

    	   int choice=sc.nextInt();
    	   switch (choice) {
			case 1->{
		     System.out.println("\n-----Inserting Regular Employee Record-----");
		     System.out.print("\nEnter number of Regular Employee Records to insert:");
		     int n=sc.nextInt();
		     for(int i=0;i<n;i++) {
		 		RegularEmployee regEmp=con.getBean(RegularEmployee.class);
				System.out.println("\nEnter Regular Employee Details:");
				System.out.print("Enter the Id:");
				regEmp.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter the Name:");
				regEmp.setName(sc.nextLine());
		
				regEmp.inputBasicSalary(sc);
				System.out.print("Enter the Bonus:");
				regEmp.setBonus(sc.nextInt());
				regEmpList.add(regEmp);
		     }
		     System.out.println("Regular Employee Records Inserted Successfully");
		     
			}
			case 2->{
		     System.out.println("\n-----Inserting Intern Employee Record-----");
		     System.out.print("\nEnter number of Intern Employee Records to insert:");
		     int n=sc.nextInt();
		     for(int i=0;i<n;i++) {
		 		InternEmployee internEmp=con.getBean(InternEmployee.class);
				System.out.println("\nEnter Intern Employee Details:");
				System.out.print("Enter the Id:");
				internEmp.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter the Name:");
				internEmp.setName(sc.nextLine());
				
				internEmp.inputBasicSalary(sc);
				internEmpList.add(internEmp);
		     }
		     System.out.println("Intern Employee Records Inserted Successfully");
			}
			case 3->{
		     System.out.println("\n-----Inserting Part Time Employee Record-----");
		     System.out.print("\nEnter number of Part Time Employee Records to insert:");
		     int n=sc.nextInt();
		     for(int i=0;i<n;i++) {
		 		PartTimeEmployee partTimeEmp=con.getBean(PartTimeEmployee.class);
				System.out.println("\nEnter Part Time Employee Details:");
				System.out.print("Enter the Id:");
				partTimeEmp.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter the Name:");
				partTimeEmp.setName(sc.nextLine());
				sc.nextLine();
				partTimeEmp.inputBasicSalary(sc);
				partTimeEmp.inputPerHourSalary(sc);
				partTimeEmp.inputTotalHour(sc);
				partTimeEmpList.add(partTimeEmp);
		     }
		     System.out.println("Part Time Employee Records Inserted Successfully");
			}
			case 4->{
		     System.out.println("\n-----Inserting Manager Record-----");
		     System.out.print("\nEnter number of Manager Records to insert:");
		     int n=sc.nextInt();
		     for(int i=0;i<n;i++) {
		 		Manager manager=con.getBean(Manager.class);
				System.out.println("\nEnter Manager Details:");
				System.out.print("Enter the Id:");
				manager.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter the Name:");
				manager.setName(sc.nextLine());
				sc.nextLine();
				manager.inputBasicSalary(sc);
				manager.inputTeamSize(sc);
				manager.inputTeamBounce(sc);
				managerList.add(manager);
		     }
		     System.out.println("Manager Records Inserted Successfully");
			}
			case 5->{
				System.out.println("\n-----Regular Employee Records-----");
//				for (int i = 0; i <regEmpList.size() ; i++) {
//					regEmpList.get(i).displayEmployeeInfo();
//				}
				for(RegularEmployee re:regEmpList) {
					re.displayEmployeeInfo();
					System.out.println();
				}
				System.out.println("Total Regular Employees:"+regEmpList.size());
			}
			case 6->{
				System.out.println("\n-----Intern Employee Records-----");
				for(InternEmployee ie:internEmpList) {
					ie.displayEmployeeInfo();
					System.out.println();
				}
				System.out.println("Total Intern Employees:"+internEmpList.size());
			}
			case 7->{
				System.out.println("\n-----Part Time Employee Records-----");
				for(PartTimeEmployee pe:partTimeEmpList) {
					pe.displayEmployeeInfo();
					System.out.println();
				}
				System.out.println("Total Part Time Employees:"+partTimeEmpList.size());
			}
			case 8->{
				System.out.println("\n-----Manager Records-----");
				for(Manager m:managerList) {
					m.displayEmployeeInfo();
					System.out.println();
				}
				System.out.println("Total Managers:"+managerList.size());
			}
			case 9->{
				int totalCount=regEmpList.size()+internEmpList.size()+partTimeEmpList.size()+managerList.size();
				System.out.println("Total Count of All Employees:"+totalCount);
			}
			case 10->{
				flag="no";
				System.out.println("Exiting Employee Info Dashboard. Goodbye!");
			}
			

			default->{
				
				System.out.println("Invalid choice! Please try again.");
			}
		}
       }
       
         con.close();   
    }
}
