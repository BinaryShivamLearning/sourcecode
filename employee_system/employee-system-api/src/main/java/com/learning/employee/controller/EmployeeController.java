package com.learning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.employee.model.Employee;
import com.learning.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", 
			methods = {
					RequestMethod.DELETE,
					RequestMethod.OPTIONS,
					RequestMethod.GET,
					RequestMethod.POST,
					RequestMethod.PUT},
			allowedHeaders = {"*"},
			allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee emp= employeeService.createEmployee(employee);

		return emp;
	}
	
	
	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}
	
	@PostMapping(path = "/empDelete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestBody Long id){
		String isDeleted = employeeService.deleteEmployee(id);
		if(isDeleted.equalsIgnoreCase("true")) {
			return ResponseEntity.ok(isDeleted);
		}
		return ResponseEntity.notFound().build();
	}
}
