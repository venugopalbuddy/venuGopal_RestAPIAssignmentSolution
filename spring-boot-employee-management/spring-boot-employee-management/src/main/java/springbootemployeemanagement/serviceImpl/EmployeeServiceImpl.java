package springbootemployeemanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import springbootemployeemanagement.model.Employee;
import springbootemployeemanagement.repository.EmployeeRepository;
import springbootemployeemanagement.service.EmployeeService;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee get() {
		log.info("inside get() method");
		Employee e1=new Employee();
		e1.setId(1);
		e1.setFirstName("Uday");
		e1.setLastName("Kiran");
		e1.setEmail("udayk@dmail.com");
		return e1;
	}
	
@Override
public Employee customInfo(int id,String firstname, String lastname, String email) {
		log.info("inside customInfo() method");
		Employee e1=new Employee();
		e1.setId(id);
		e1.setFirstName(firstname);
		e1.setLastName(lastname);
		e1.setEmail(email);
		return e1;
		
	}

@Override
public List<Employee> getAllEmployees() {
	return empRepository.findAll();
}

@Override
public String addSingleEmployee(Employee emp) {
	
	empRepository.save(emp);
	empRepository.flush();
	return "Employee saved";
}

@Override
public List<Employee> getEmployeesSortedByNameASC(Direction direction) {
	return empRepository.findAll(Sort.by(direction.ASC,"firstName"));
}

@Override
public List<Employee> getEmployeesSortedByNameDESC(Direction direction) {
	return empRepository.findAll(Sort.by(direction.DESC,"firstName"));
}

public ResponseEntity<List<Employee>> getAllEmployeeByFirstName(@RequestParam String firstname) {
	return new ResponseEntity<List<Employee>>(empRepository.findByFirstName(firstname),HttpStatus.OK);
}

public Optional<Employee> getEmployeeById(Integer id) {
	return empRepository.findById(id);
}
public String deleteById (Integer id) {
	 empRepository.deleteById(id);
	 return "deleted Employee record";
}

 public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee emp) {
	 
	 Employee e1 = empRepository.getOne(id);
	 e1.setEmail(emp.getEmail());
	 e1.setFirstName(emp.getFirstName());
	 e1.setLastName(emp.getLastName());
	Employee e2= empRepository.saveAndFlush(e1);
	 return ResponseEntity.ok().body(e2);
	 
}
	



}
