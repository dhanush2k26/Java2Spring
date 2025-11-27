package com.example.model;

public class RegularEmployee extends Employee {
    private double bonus;
    
    private static final double DEFAULT_BONUS = 2000.0; // Default bonus
    
    public RegularEmployee() {
        System.out.println("Regular Employee created");
    }
    
    public void setBonus(double bonus) {
        this.bonus = (bonus >= 0) ? bonus : DEFAULT_BONUS;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }
    
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Employee Type: " + getEmployeeType());
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("------------------------");
    }
    
    @Override
    public String getEmployeeType() {
        return "Regular Employee";
    }
}