package com.example.EMS.model;

public interface ISalary {
   void setId(int id);
   void setName(String name);
   void setBasic_salary(double basic_salary);
   double calculateSalary();
   void displayEmployeeInfo();

}
