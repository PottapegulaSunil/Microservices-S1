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

import com.payroll.entity.Leave;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-leave") 
public interface EmployeeLeaveProxy {
	
	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="fallbackMethodForGetLeaveById")
	@GetMapping(value ="/leave/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public Leave getLeaveById(@PathVariable("id") Integer id);

	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="fallbackMethodForGetAllLeave")
	@GetMapping(value ="/leaves", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public List<Leave> getAllLeave();
	
	
	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="fallbackMethodForDeleteLeaveById")
	@DeleteMapping(value = "/leave/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteLeaveById(@PathVariable("id") Integer id);
	
	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/leave", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Leave updateLeave(@RequestBody Leave leave);
	
	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/leave", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Leave addLeave(@RequestBody Leave leave);
	
	@Retry(name = "emp-leave")
	@CircuitBreaker(name="emp-leave", fallbackMethod="fallbackMethodForGetAllLeavesOfOneEmployee")
	@GetMapping(value = "/leave/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Leave> getAllLeavesOfOneEmployee(@PathVariable("empid") Integer empid);
    

	public default List<Leave> fallbackMethodForGetAllLeave(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Leave>();
	}
	
	public default Leave fallbackMethodForGetLeaveById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Leave fallbackLeave = new Leave(id,null, "Fall Back leave", "Application Down", "Error",
				 "Application Down", "Error");
		return fallbackLeave;
	}
	
	public default void fallbackMethodForDeleteLeaveById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Leave commonfallbackMethod(Leave leave, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Leave fallbackLeave = new Leave(null,null, "Fall Back Leave", "Application Down", "Error",
				 "Application Down", "Error");
		return fallbackLeave;
	}
	
	public default List<Leave> fallbackMethodForGetAllLeavesOfOneEmployee(Integer empid, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Leave>();
	}
	
	
	
	

}
