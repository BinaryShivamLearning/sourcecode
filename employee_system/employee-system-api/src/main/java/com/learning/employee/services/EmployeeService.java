package com.learning.employee.services;

import java.util.List;

import com.learning.employee.model.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);

	public List<Employee> getEmployee();

	public String deleteEmployee(Long id);

}
