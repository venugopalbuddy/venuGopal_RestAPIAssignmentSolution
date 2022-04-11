package springbootemployeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import springbootemployeemanagement.model.Employee;

@Component
public interface EmployeeService {

	Employee get();
	
	List<Employee> getAllEmployees();
	
	String addSingleEmployee(Employee emp);

	Employee customInfo(int id,String Name, String Department, String Country);
	
	List<Employee> getEmployeesSortedByNameASC(Direction direction);
	
	List<Employee> getEmployeesSortedByNameDESC(Direction direction);
	
	String deleteById (Integer id);
	
	Optional<Employee> getEmployeeById(Integer id);
	
	ResponseEntity<List<Employee>> getAllEmployeeByFirstName(String firstname);
	
	ResponseEntity<Employee> updateEmployee(Integer id,Employee emp);

}