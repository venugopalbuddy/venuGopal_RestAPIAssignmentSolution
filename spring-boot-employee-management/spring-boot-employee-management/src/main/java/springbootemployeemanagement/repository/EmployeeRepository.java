package springbootemployeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootemployeemanagement.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	List<Employee> findByFirstName(String firstname);
}
