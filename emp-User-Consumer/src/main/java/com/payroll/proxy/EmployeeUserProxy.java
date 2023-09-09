package com.payroll.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.payroll.entity.Employee;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-user") 
public interface EmployeeUserProxy {
	
	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="fallbackMethodForGetEmployeeById")
	@GetMapping(value ="/employee/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public Employee getEmployeeById(@PathVariable("id") Integer id);

	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="fallbackMethodForGetAllEmployees")
	@GetMapping(value ="/employees", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public List<Employee> getAllEmployees();
	
	
	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="fallbackMethodForDeleteEmployeeById")
	@DeleteMapping(value = "/employee/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") Integer id);
	
	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Employee updateEmployee(@RequestBody Employee employee);
	
	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee);
	
	@Retry(name = "emp-user")
	@CircuitBreaker(name="emp-user", fallbackMethod="fallbackMethodForEmployeeLogin")
	@PostMapping(value="/employee/login",  produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
    public Employee Employeelogin(@RequestBody Employee employee);
    
    
	/*
	public default ResponseEntity<Employee> fallbackMethodForGetEmployeeById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Employee fallbackEmployee = new Employee(id, "Fall Back Employee", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackEmployee);
	}*/

	public default List<Employee> fallbackMethodForGetAllEmployees(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Employee>();
	}
	
	public default Employee fallbackMethodForGetEmployeeById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Employee fallbackEmployee = new Employee(id, "Fall Back Employee", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return fallbackEmployee;
	}
	
	public default void fallbackMethodForDeleteEmployeeById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Employee commonfallbackMethod(Employee employee, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Employee fallbackEmployee = new Employee(null, "Fall Back Employee", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return fallbackEmployee;
	}
	
	public default Employee fallbackMethodForEmployeeLogin(Employee employee, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Employee fallbackEmployee = new Employee(null, "Fall Back Employee", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return fallbackEmployee;
	}
	
	
	
	

}
