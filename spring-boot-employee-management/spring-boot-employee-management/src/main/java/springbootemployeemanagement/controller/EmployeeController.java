package springbootemployeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springbootemployeemanagement.model.Employee;
import springbootemployeemanagement.repository.EmployeeRepository;
import springbootemployeemanagement.service.EmployeeService;
import springbootemployeemanagement.serviceImpl.EmployeeServiceImpl;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	

	@GetMapping("/info")
	public Employee get() {

		return employeeService.get();
	}
	
	@GetMapping("/employee-list") 
	public List<Employee> getAllEmployees() {
	  return employeeService.getAllEmployees();
	  
	  }
	 
	@PostMapping("/add-employee")
	public String addSingleEmployee(Employee emp) {
		return employeeService.addSingleEmployee(emp);
	}

	@PostMapping("/customInfo")
	public Employee customInfo(int Id, String firstName, String lastName, String email) {

		return employeeService.customInfo(Id, firstName, lastName, email);

	}
	
	@GetMapping("/asc-employee-list")
	public List<Employee> getEmployeesSortedByNameASC(Direction direction) {
		return employeeService.getEmployeesSortedByNameASC(direction);
	}
	
	@GetMapping("/desc-employee-list")
	public List<Employee> getEmployeesSortedByNameDESC(Direction direction) {
		return employeeService.getEmployeesSortedByNameDESC(direction);
	}
	
	@GetMapping("/employee-by-name/{firstname}")
	public ResponseEntity<List<Employee>> getAllEmployeeByFirstName(String firstname) {
		return employeeService.getAllEmployeeByFirstName(firstname);
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public String deleteById (Integer id) {
		return employeeService.deleteById(id);
	}
	
	@GetMapping("/employee-by-id/{id}")
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(Integer id, Employee emp) {
		 return employeeService.updateEmployee(id, emp);
	}
	
	
}


