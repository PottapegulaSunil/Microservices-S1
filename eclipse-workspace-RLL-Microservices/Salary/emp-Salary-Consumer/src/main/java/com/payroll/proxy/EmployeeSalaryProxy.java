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

import com.payroll.entity.Salary;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-salary") 
public interface EmployeeSalaryProxy {
	
	
	@Retry(name = "emp-salary")
	@CircuitBreaker(name="emp-salary", fallbackMethod="fallbackMethodForFindByEmpid")
	@GetMapping(value = "/salary/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Salary> findByEmpid(@PathVariable("empid") Integer empid);

	
	@Retry(name = "emp-salary")
	@CircuitBreaker(name="emp-salary", fallbackMethod="fallbackMethodForGetSalaryById")
	@GetMapping(value = "/salary/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public Salary getSalaryById(@PathVariable("id") Integer id);

	@Retry(name = "emp-salary")
	@CircuitBreaker(name="emp-salary", fallbackMethod="fallbackMethodForGetAllSalarys")
	@GetMapping(value = "/salaries", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Salary> getAllSalarys();
	
	@Retry(name = "emp-salary")
	@CircuitBreaker(name="emp-salary", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/salary", produces = {MediaType.APPLICATION_JSON_VALUE}, 
				consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Salary updateESalary(@RequestBody Salary salary);
	
	@Retry(name = "emp-salary")
	@CircuitBreaker(name="emp-salary", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/salary", produces = {MediaType.APPLICATION_JSON_VALUE}, 
				consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Salary addSalary(@RequestBody Salary salary);
	
    
	/*
	public default ResponseEntity<Salary> fallbackMethodForGetSalaryById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Salary fallbackSalary = new Salary(id, "Fall Back Salary", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackSalary);
	}*/

	public default List<Salary> fallbackMethodForFindByEmpid(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Salary>();
	}
	
	public default Salary fallbackMethodForGetSalaryById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Salary fallbackSalary = new Salary(id,null, "Fall Back Salary", "Application Down", "Error",
				 null);
		return fallbackSalary;
	}
	//Integer id, Integer empid, String name, String date, String month, Integer amount
	public default List<Salary> fallbackMethodForGetAllSalarys(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Salary>();
	}
	
	public default Salary commonfallbackMethod(Salary employee, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Salary fallbackSalary = new Salary(null,null, "Fall Back Salary", "Application Down", "Error",
				 null);
		return fallbackSalary;
	}


}
