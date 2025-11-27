package Employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Manager extends Employee {
    private double teamBonus;
    private int teamSize;

    public Manager(
            @Value("${employee.manager.default.name}") String name,
            @Value("${employee.manager.default.id}") int id,
            @Value("${employee.manager.default.baseSalary}") double baseSalary,
            @Value("${employee.manager.default.teamBonus}") double teamBonus,
            @Value("${employee.manager.default.teamSize}") int teamSize) {
        super(name, id, baseSalary);
        this.teamBonus = teamBonus;
        this.teamSize = teamSize;
        System.out.println("Manager constructor called with default values: " + name);
    }

    public double getTeamBonus() {
        return teamBonus;
    }

    public void setTeamBonus(double teamBonus) {
        this.teamBonus = teamBonus;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + teamBonus + (teamSize * 100);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Team Bonus: ₹%.2f, Team Size: %d, Total Salary: ₹%.2f", 
                teamBonus, teamSize, calculateSalary());
    }
}