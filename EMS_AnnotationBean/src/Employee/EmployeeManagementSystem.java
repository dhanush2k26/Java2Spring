package Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class EmployeeManagementSystem {

    private final EmployeeService employeeService;
    private boolean alreadyRun = false;

    public EmployeeManagementSystem(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void init() {
        System.out.println("EmployeeManagementSystem initialized");
        run();
    }

    public void cleanup() {
        System.out.println("EmployeeManagementSystem cleanup");
    }

    public void run() {
        if (alreadyRun) {
            System.out.println("System already executed.");
            return;
        }
        alreadyRun = true;
        
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Employee " + (i + 1) + " ---");
                
                System.out.println("Employee type (regular/manager/intern/partTime): ");
                String type = sc.nextLine();

                // Get user input with option to skip (press Enter for default)
                System.out.println("Enter name (press Enter for default): ");
                String nameInput = sc.nextLine();
                String name = nameInput.trim().isEmpty() ? null : nameInput;

                Integer id = null;
                Double baseSalary = null;
                Double bonus = null;
                Double teamBonus = null;
                Integer teamSize = null;

                if (name != null) {
                    System.out.println("Enter id (press Enter for default): ");
                    String idInput = sc.nextLine();
                    if (!idInput.trim().isEmpty()) {
                        id = Integer.parseInt(idInput);
                    }

                    System.out.println("Enter base salary (press Enter for default): ");
                    String salaryInput = sc.nextLine();
                    if (!salaryInput.trim().isEmpty()) {
                        baseSalary = Double.parseDouble(salaryInput);
                    }
                }

                if (type.equalsIgnoreCase("regular")) {
                    if (name != null) {
                        System.out.println("Enter bonus (press Enter for default): ");
                        String bonusInput = sc.nextLine();
                        if (!bonusInput.trim().isEmpty()) {
                            bonus = Double.parseDouble(bonusInput);
                        }
                    }
                    employeeService.addRegularEmployee(name, id, baseSalary, bonus);
                    
                } else if (type.equalsIgnoreCase("manager")) {
                    if (name != null) {
                        System.out.println("Enter team bonus (press Enter for default): ");
                        String teamBonusInput = sc.nextLine();
                        if (!teamBonusInput.trim().isEmpty()) {
                            teamBonus = Double.parseDouble(teamBonusInput);
                        }

                        System.out.println("Enter team size (press Enter for default): ");
                        String teamSizeInput = sc.nextLine();
                        if (!teamSizeInput.trim().isEmpty()) {
                            teamSize = Integer.parseInt(teamSizeInput);
                        }
                    }
                    employeeService.addManager(name, id, baseSalary, teamBonus, teamSize);
                }
                else if (type.equalsIgnoreCase("intern")) {
					if (name != null) {
						System.out.println("Enter stipend (press Enter for default): ");
						String stipendInput = sc.nextLine();
						Double stipend = null;
						if (!stipendInput.trim().isEmpty()) {
							stipend = Double.parseDouble(stipendInput);
						}
						employeeService.addIntern(name, id, baseSalary, stipend);
					} else {
						employeeService.addIntern(name, id, baseSalary, null);
					}
				} 
				else if (type.equalsIgnoreCase("partTime")) {
					if (name != null) {
						System.out.println("Enter hourly rate (press Enter for default): ");
						String rateInput = sc.nextLine();
						Double hourlyRate = null;
						if (!rateInput.trim().isEmpty()) {
							hourlyRate = Double.parseDouble(rateInput);
						}

						System.out.println("Enter hours worked (press Enter for default): ");
						String hoursInput = sc.nextLine();
						Integer hoursWorked = null;
						if (!hoursInput.trim().isEmpty()) {
							hoursWorked = Integer.parseInt(hoursInput);
						}
						employeeService.addPartTimeEmployee(name, id, baseSalary, hourlyRate, hoursWorked);
					} else {
						employeeService.addPartTimeEmployee(name, id, baseSalary, null, null);
					}
				} 
				else {
					System.out.println("Unknown employee type. Skipping...");
				}
            }

            // Print all employees
            System.out.println("\n=== All Employees ===");
            employeeService.printAllEmployees();

            // Calculate total salary expenditure
            double totalSalary = employeeService.calculateTotalSalaryExpenditure();
            System.out.printf("\nTotal Salary Expenditure: ₹%.2f\n", totalSalary);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Employee");

        ((AnnotationConfigApplicationContext) context).close();
    }
}