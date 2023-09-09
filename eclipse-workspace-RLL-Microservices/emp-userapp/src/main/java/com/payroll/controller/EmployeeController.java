package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.Employee;
import com.payroll.service.EmployeeService;

@RestController
@Scope(value = "request")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee) {
		log.debug("Received a request to add an employee: " + employee);
		Employee addedEmployee = employeeService.addEmployee(employee);
		log.info("Employee added: ", addedEmployee);
		return addedEmployee;
	}
	
	@PutMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Employee updateEmployee(@RequestBody Employee employee) {
		log.debug("Received a request to update an employee: " + employee);
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		log.info("Employee updated: ", updatedEmployee);
		return updatedEmployee;
	}
	
	@DeleteMapping(value = "/employee/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		log.debug("Received a request to delete an employee with id: " + id);
		employeeService.deleteEmployeeById(id);
		log.info("Employee deleted with id: ", id);
	}
	
	@GetMapping(value = "/employee/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		log.debug("Received a request to get an employee with id: " + id);
		Employee employeeById = employeeService.getEmployeeById(id);
		log.info("Return Value: ", employeeById);
		return employeeById;
	}
	
	@GetMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Employee> getAllEmployees() {
		log.debug("Received a request to view all employee");
		 List<Employee> allEmployees = employeeService.getAllEmployees();
		 log.info("All Employees Return Value: " + allEmployees);
		 return allEmployees;
		
	}
	
	@PostMapping(value="/employee/login",  produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
    public Employee Employeelogin(@RequestBody Employee employee){
		log.debug("Received a login Request: " + employee);
        Employee employeeLogin = employeeService.login(employee.getEmail(), employee.getPassword());
        log.info("Return Value for Employee login: " + employeeLogin);
        return employeeLogin;
    }

}
