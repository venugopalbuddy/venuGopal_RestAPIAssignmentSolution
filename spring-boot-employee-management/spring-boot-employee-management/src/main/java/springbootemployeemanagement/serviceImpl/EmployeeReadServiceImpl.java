package springbootemployeemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootemployeemanagement.model.Employee;
import springbootemployeemanagement.repository.EmployeeRepository;
import springbootemployeemanagement.service.EmployeeService;



@Service
public  class EmployeeReadServiceImpl {

	@Autowired
	private EmployeeRepository readRepository;
	
	public List<Employee> getAllEmployees() {
		return readRepository.findAll();
	}
}
