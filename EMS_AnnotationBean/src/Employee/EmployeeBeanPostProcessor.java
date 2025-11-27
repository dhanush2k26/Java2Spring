package Employee;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Employee) {
            System.out.println("Before initialization - Bean: " + beanName + ", Class: " + bean.getClass().getSimpleName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Employee) {
            System.out.println("After initialization - Bean: " + beanName + ", Class: " + bean.getClass().getSimpleName());
            System.out.println("Employee created with default values: " + ((Employee) bean).getName());
        }
        return bean;
    }
}