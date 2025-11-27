package Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:employee.properties")
public class AppConfig {


    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public EmployeeManagementSystem employeeManagementSystem(EmployeeService employeeService) {
        return new EmployeeManagementSystem(employeeService);
    }
}