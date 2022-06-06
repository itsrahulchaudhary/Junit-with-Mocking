package in.rahulit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.rahulit.model.Employee;
import in.rahulit.repository.EmployeeRepository;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		// given - precondition or setup
		Employee employee = new Employee();
		//employee.setId(1);
		employee.setFirstName("Rahul");
		employee.setLastName("Chaudhary");
		employee.setEmail("rr@gmail.com");

		// when - action or the behaviour that we are going test
		Employee saveEmployee = employeeRepository.save(employee);
		System.out.println("aaaaaa " + saveEmployee);

	}

}
