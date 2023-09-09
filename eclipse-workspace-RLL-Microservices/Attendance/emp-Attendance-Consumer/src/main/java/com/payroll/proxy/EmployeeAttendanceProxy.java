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

import com.payroll.entity.Attendance;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-attendance") 
public interface EmployeeAttendanceProxy {
	
	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="fallbackMethodForGetAttendanceById")
	@GetMapping(value ="/attendance/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public Attendance getAttendanceById(@PathVariable("id") Integer id);

	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="fallbackMethodForGetAllAttendances")
	@GetMapping(value ="/attendances", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public List<Attendance> getAllAttendances();
	
	
	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="fallbackMethodForDeleteAttendanceById")
	@DeleteMapping(value = "/attendance/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAttendanceById(@PathVariable("id") Integer id);
	
	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/attendance", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Attendance updateAttendance(@RequestBody Attendance attendance);
	
	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/attendance", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Attendance addAttendance(@RequestBody Attendance attendance);
	
	

	@Retry(name = "emp-attendance")
	@CircuitBreaker(name="emp-attendance", fallbackMethod="fallbackMethodForGetAllAttendancesOfOneEmployee")
	@GetMapping(value = "/attendance/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Attendance> getAllAttendancesOfOneEmployee(@PathVariable("empid") Integer empid);
	   
    
	/*
	public default ResponseEntity<Employee> fallbackMethodForGetEmployeeById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Employee fallbackEmployee = new Employee(id, "Fall Back Employee", "Application Down", "Error",
				 "Application Down", "Error","Application Down", "Error");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackEmployee);
	}*/

	public default List<Attendance> fallbackMethodForGetAllAttendances(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Attendance>();
	}
	
	public default Attendance fallbackMethodForGetAttendanceById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Attendance fallbackAttendance = new Attendance(id, null,"Fall Back Attendance", "Application Down", "Error",
				 "Application Down");
		return fallbackAttendance;
	}
	
	public default void fallbackMethodForDeleteAttendanceById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Attendance commonfallbackMethod(Attendance Attendance, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Attendance fallbackAttendance = new Attendance(null, null,"Fall Back Attendance", "Application Down", "Error",
				 "Application Down");
		return fallbackAttendance;
	}
	
	
	public default List<Attendance> fallbackMethodForGetAllAttendancesOfOneEmployee(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Attendance>();
	
	
	}
	
	

}
