package Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    
    private final ApplicationContext applicationContext;
    private final List<Employee> employees = new ArrayList<>();

    @Autowired
    public EmployeeService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        System.out.println("EmployeeService initialized with ApplicationContext");
    }

    public void addRegularEmployee(String name, Integer id, Double baseSalary, Double bonus) {
        RegularEmployee employee = applicationContext.getBean(RegularEmployee.class);
        
        // Only update if user provided values (non-null)
        if (name != null && !name.trim().isEmpty()) {
            employee.setName(name);
        }
        if (id != null) {
            employee.setId(id);
        }
        if (baseSalary != null) {
            employee.setBaseSalary(baseSalary);
        }
        if (bonus != null) {
            employee.setBonus(bonus);
        }
        
        employees.add(employee);
        System.out.println("Added Regular Employee: " + employee.getName());
    }

    public void addManager(String name, Integer id, Double baseSalary, Double teamBonus, Integer teamSize) {
        Manager manager = applicationContext.getBean(Manager.class);
        
        // Only update if user provided values (non-null)
        if (name != null && !name.trim().isEmpty()) {
            manager.setName(name);
        }
        if (id != null) {
            manager.setId(id);
        }
        if (baseSalary != null) {
            manager.setBaseSalary(baseSalary);
        }
        if (teamBonus != null) {
            manager.setTeamBonus(teamBonus);
        }
        if (teamSize != null) {
            manager.setTeamSize(teamSize);
        }
        
        employees.add(manager);
        System.out.println("Added Manager: " + manager.getName());
    }
    public void addPartTimeEmployee(String name, Integer id, Double baseSalary, Double hourlyRate, Integer hoursWorked) {
		PartTimeEmployee partTimeEmployee = applicationContext.getBean(PartTimeEmployee.class);
		
		// Only update if user provided values (non-null)
		if (name != null && !name.trim().isEmpty()) {
			partTimeEmployee.setName(name);
		}
		if (id != null) {
			partTimeEmployee.setId(id);
		}
		if (baseSalary != null) {
			partTimeEmployee.setBaseSalary(baseSalary);
		}
		if (hourlyRate != null) {
			partTimeEmployee.setHourlyRate(hourlyRate);
		}
		if (hoursWorked != null) {
			partTimeEmployee.setHoursWorked(hoursWorked);
		}
		
		employees.add(partTimeEmployee);
		System.out.println("Added Part-Time Employee: " + partTimeEmployee.getName());
	}
    
    public void addIntern(String name, Integer id, Double baseSalary, Double stipend) {
		InternEmployee intern = applicationContext.getBean(InternEmployee.class);
		
		// Only update if user provided values (non-null)
		if (name != null && !name.trim().isEmpty()) {
			intern.setName(name);
		}
		if (id != null) {
			intern.setId(id);
		}
		if (baseSalary != null) {
			intern.setBaseSalary(baseSalary);
		}
		employees.add(intern);
		System.out.println("Added Intern: " + intern.getName());
	}

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public double calculateTotalSalaryExpenditure() {
        return employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();
    }

    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}