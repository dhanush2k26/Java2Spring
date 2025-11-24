package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
   private int id;
   private String name;
     @Autowired
     private EmpAddress empAddress;
    public int getId() {
         return id;
    }
    public void setId(int id) {
         this.id = id;
    }
    public String getName() {
         return name;
    }
    public void setName(String name) {
         this.name = name;
    }
     public EmpAddress getEmpAddress() {
          return empAddress;
     }
     public void setEmpAddress(EmpAddress empAddress) {
          this.empAddress = empAddress;
     }
    @Override
    public String toString() {
          return "Employee [id=" + id + ", name=" + name + ", empAddress=" + empAddress + "]";
    }
}
