package Employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class PartTimeEmployee  extends Employee {
	private double hourlyRate;
	private int hoursWorked;

	public PartTimeEmployee(
			@Value("${employee.partTime.default.name}")
			String name,
			@Value("${employee.partTime.default.id}")
			int id, 
			@Value("${employee.partTime.default.baseSalary}")
			double baseSalary,
			@Value("${employee.partTime.default.hourlyRate}")
			double hourlyRate,
			@Value("${employee.partTime.default.hoursWorked}")
			int hoursWorked) {
		super(name, id, baseSalary);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return baseSalary + (hourlyRate * hoursWorked);
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Hourly Rate: ₹%.2f, Hours Worked: %d Total Salary: ₹%.2f", hourlyRate, hoursWorked, calculateSalary());
	}

}
