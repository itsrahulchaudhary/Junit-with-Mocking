package in.rahulit.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.rahulit.model.Employee;

//@DataJpaTest

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTestes {

	@Autowired
	private EmployeeRepository employeeRepository;

	// JUnit test for save employee operation
	@DisplayName("JUnit test for save employee operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Raja");
		employee.setLastName("Chaudhary");
		employee.setEmail("rr@gmail.com");

		// when - action or the behaviour that we are going test
		Employee saveEmployee = employeeRepository.save(employee);

		// then - verify the output
		Assertions.assertThat(saveEmployee).isNotNull();
		Assertions.assertThat(saveEmployee.getId()).isGreaterThan(0);
	}

	// JUnit test for get all employees operation
	@Test
	public void givenEmployeeList_whenFindAll_thenEmployeesList() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Aman");
		employee.setLastName("Dora");
		employee.setEmail("dora@gmail.com");

		Employee employee2 = new Employee();
		employee2.setFirstName("Sanjay");
		employee2.setLastName("Chaudhary");
		employee2.setEmail("sanjay@gmail.com");

		employeeRepository.save(employee);
		employeeRepository.save(employee2);

		// when - action or the behaviour that we are going test
		List<Employee> employeeList = employeeRepository.findAll();
		// then - verify the output
		Assertions.assertThat(employeeList).isNotNull();
		Assertions.assertThat(employeeList.size()).isGreaterThan(8);
	}

	// JUnit test for get employee by Id operation
	@Test
	public void givenEmployeeObject_whenFindById_thenEmployeeObject() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Aman");
		employee.setLastName("Dora");
		employee.setEmail("dora@gmail.com");
		employeeRepository.save(employee);

		// when - action or the behaviour that we are going test
		Employee employeeId = employeeRepository.findById(employee.getId()).get();

		// then - verify the output
		Assertions.assertThat(employeeId).isNotNull();
	}

	// JUnit test for get employee by email operation
	@DisplayName("JUnit test for get employee by email operation")
	@Test
	public void givenEmployeeEmail_whenFindByEmail_thenEmployeeObject() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Amaan");
		employee.setLastName("Dora");
		employee.setEmail("don@gmail.com");
		employeeRepository.save(employee);

		// when - action or the behaviour that we are going test
		Optional<Employee> findByEmail = employeeRepository.findByEmail(employee.getEmail());

		// then - verify the output
		Assertions.assertThat(findByEmail).isNotNull();
	}

	// JUnit test for update employee operation
	@DisplayName("JUnit test for update employee operation")
	@Test
	public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Aman");
		employee.setLastName("Dora");
		employee.setEmail("don@gmail.com");
		employeeRepository.save(employee);

		// when - action or the behaviour that we are going test
		Employee saveEmployee = employeeRepository.findById(employee.getId()).get();
		saveEmployee.setFirstName("Joe");
		saveEmployee.setLastName("Doe");
		Employee updateEmployee = employeeRepository.save(saveEmployee);

		// then - verify the output
		Assertions.assertThat(updateEmployee.getEmail()).isEqualTo("don@gmail.com");
		Assertions.assertThat(updateEmployee.getFirstName()).isEqualTo("Joe");
	}

	// JUnit test for delete employee operation
	@DisplayName("JUnit test for delete employee operation")
	@Test
	public void givenEmployeeObject_whenDeleteEmployee_thenRemoveEmployee() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Aman");
		employee.setLastName("Dora");
		employee.setEmail("don@gmail.com");
		employeeRepository.save(employee);

		// when - action or the behaviour that we are going test
		employeeRepository.deleteById(employee.getId());
		// employeeRepository.delete(employee);
		Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

		// then - verify the output
		Assertions.assertThat(employeeOptional).isEmpty();
	}

	// JUnit test for custom query using JPQL with index  
	@DisplayName("JUnit test for custom query using JPQL with index")
	@Test
	public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {
		// given - precondition or setup
		Employee employee = new Employee();
		employee.setFirstName("Aman");
		employee.setLastName("Dora");
		employee.setEmail("don@gmail.com");
		employeeRepository.save(employee);
		String firstName = "Aman";
		String lastName = "Dora";

		// when - action or the behaviour that we are going test
		Employee saveEmployee = employeeRepository.findByJPQL(firstName, lastName);

		// then - verify the output
		Assertions.assertThat(saveEmployee).isNotNull();
	}

}
