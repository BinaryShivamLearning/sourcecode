package com.learning.employee.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.employee.entity.EmployeeEntity;
import com.learning.employee.model.Employee;
import com.learning.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepo.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getEmployee() {
		List<EmployeeEntity> empEntities = employeeRepo.findAll();
		List<Employee> employee = empEntities
								.stream()
								.map(emp -> (
									new Employee(emp.getId(),
												emp.getFirstName(),
												emp.getLastName(),
												emp.getEmail())
								)).collect(Collectors.toList());
		return employee;
	}

	@Override
	public String deleteEmployee(Long id) {
		Optional<EmployeeEntity> entity = employeeRepo.findById(id);
		if(entity.isPresent()) {
			employeeRepo.delete(entity.get());
			return "true";
		}
		return "false";
	}

}
