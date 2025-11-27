package Employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class InternEmployee extends Employee {

	public InternEmployee(
			@Value("${employee.intern.default.name}")
			String name,
			@Value("${employee.intern.default.id}")
			int id,
			@Value("${employee.intern.default.baseSalary}")
			double baseSalary) {
		super(name, id, baseSalary);
		
	}
	@Override
	public double calculateSalary() {
		return baseSalary; 
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Total Salary: ₹%.2f", calculateSalary());
	}

}
