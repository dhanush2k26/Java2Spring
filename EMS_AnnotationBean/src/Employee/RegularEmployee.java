package Employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")	
public class RegularEmployee extends Employee {
	private double bonus;
    public RegularEmployee(
            @Value("${employee.regular.default.name}") String name,
            @Value("${employee.regular.default.id}") int id,
            @Value("${employee.regular.default.baseSalary}") double baseSalary,
            @Value("${employee.regular.default.bonus}") double bonus) {
		super(name, id, baseSalary);
		    this.bonus =bonus;
		   System.out.println("RegularEmployee constructor called with default values: " + name);
	}
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Bonus: ₹%.2f, Total Salary: ₹%.2f", bonus, calculateSalary());
    }
}