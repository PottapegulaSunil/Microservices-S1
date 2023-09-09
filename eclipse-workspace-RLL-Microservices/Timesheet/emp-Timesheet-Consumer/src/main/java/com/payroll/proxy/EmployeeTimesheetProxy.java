package com.payroll.proxy;

import java.util.ArrayList;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.payroll.entity.Timesheet;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-timesheet") 
public interface EmployeeTimesheetProxy {
	
	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="fallbackMethodForGetTimesheetById")
	@GetMapping(value ="/timesheet/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public Timesheet getTimesheetById(@PathVariable("id") Integer id);

	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="fallbackMethodForGetAllTimesheets")
	@GetMapping(value ="/timesheets", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public List<Timesheet> getAllTimesheets();
	
	
	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="fallbackMethodForDeleteTimesheetById")
	@DeleteMapping(value = "/timesheet/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTimesheetById(@PathVariable("id") Integer id);
	
	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/timesheet", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Timesheet updateTimesheet(@RequestBody Timesheet timesheet);
	
	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/timesheet", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Timesheet addTimesheet(@RequestBody Timesheet timesheet);

	@Retry(name = "emp-timesheet")
	@CircuitBreaker(name="emp-timesheet", fallbackMethod="fallbackMethodForGetAllTimesheetsOfOneEmployee")
	@GetMapping(value = "/timesheet/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Timesheet> getAllTimesheetsOfOneEmployee(@PathVariable("empid") Integer empid);
	   
	
	
	public default List<Timesheet> fallbackMethodForGetAllTimesheets(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Timesheet>();
	}
	
	public default Timesheet fallbackMethodForGetTimesheetById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Timesheet fallbackTimesheet = new Timesheet(id, null,"Fall Back Timesheet", "Application Down", "Error",
				 "Application Down", "Error");
		return fallbackTimesheet;
	}
	
	public default void fallbackMethodForDeleteTimesheetById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Timesheet commonfallbackMethod(Timesheet Timesheet, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Timesheet fallbackTimesheet = new Timesheet(null, null,"Fall Back timesheet", "Application Down", "Error",
				 "Application Down","Error");
		return fallbackTimesheet;
	}
	
	
	public default List<Timesheet> fallbackMethodForGetAllTimesheetsOfOneEmployee(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Timesheet>();
	
	
	}
	
	

}
