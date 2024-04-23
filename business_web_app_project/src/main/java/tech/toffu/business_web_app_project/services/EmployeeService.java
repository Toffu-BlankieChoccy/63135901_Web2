package tech.toffu.business_web_app_project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.toffu.business_web_app_project.models.Employee;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
}
