package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.Employee;
import com.payroll.proxy.EmployeeUserProxy;

@RestController
@Scope("request")
public class EmployeeConsumerRestController {
	
	@Autowired
	private EmployeeUserProxy empuserproxy;
	
	private Logger log = LoggerFactory.getLogger(EmployeeConsumerRestController.class);
	
	@GetMapping("/get-employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
	
		log.debug("In getEmployeeById with Id: " + id);
		Employee employee = empuserproxy.getEmployeeById(id);
		log.debug("In getEmployeeById with return value Employee: " + employee);
		return employee;
	}

	@GetMapping("/get-employees")
	public List<Employee> getAllEmployees() {
	
		List<Employee> employees = empuserproxy.getAllEmployees();
		log.debug("In getAllEmployees with return value Employees: " + employees);
		return employees;
		
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete an Employee with Id: " + id);
		empuserproxy.deleteEmployeeById(id);
	}
	
	@PostMapping("/add-employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.debug("Request recieved to add an Employee: " + employee);
		return empuserproxy.addEmployee(employee);
	}
	
	@PutMapping("/update-employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		log.debug("Request recieved to update an Employee: " + employee);
		return empuserproxy.updateEmployee(employee);
	}
	
	@PostMapping("/login-employee")
	public Employee Employeelogin(@RequestBody Employee employee) {
		log.debug("Login Request recieved with credentials: " + employee);
		return empuserproxy.Employeelogin(employee);
	}
	
	
	
	
	
	
	
}
