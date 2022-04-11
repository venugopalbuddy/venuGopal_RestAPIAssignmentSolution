package springbootemployeemanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootemployeemanagement.model.Employee;
import springbootemployeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeCreateServiceImpl {

	@Autowired
	private EmployeeRepository createRepository;
	
	public String addSingleStudent(Employee emp) {
		
		createRepository.save(emp);
		createRepository.flush();
		return "Employee saved";
	}
}
