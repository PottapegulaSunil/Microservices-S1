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

import com.payroll.entity.AdminModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="emp-admin") 
public interface AdminUserProxy {
	
	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="fallbackMethodForGetAdminById")
	@GetMapping(value ="/admin/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public AdminModel getAdminById(@PathVariable("id") Integer id);

	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="fallbackMethodForGetAllAdmins")
	@GetMapping(value ="/admins", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public List<AdminModel> getAllAdmins();
	
	
	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="fallbackMethodForDeleteAdminById")
	@DeleteMapping(value = "/admin/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAdminById(@PathVariable("id") Integer id);
	
	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="commonfallbackMethod")
	@PutMapping(value = "/admin", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public AdminModel updateAdmin(@RequestBody AdminModel admin);
	
	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="commonfallbackMethod")
	@PostMapping(value = "/admin", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public AdminModel addAdmin(@RequestBody AdminModel admin);
	
	@Retry(name = "emp-admin")
	@CircuitBreaker(name="emp-admin", fallbackMethod="fallbackMethodForAdminLogin")
	@PostMapping(value="/admin/login",  produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
    public AdminModel adminLogin(@RequestBody AdminModel admin);
    
	public default List<AdminModel> fallbackMethodForGetAllAdmins(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<AdminModel>();
	}
	
	public default AdminModel fallbackMethodForGetAdminById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		AdminModel fallbackAdmin = new AdminModel(id, "Fall Back Admin", "Application Down", "Error");
		return fallbackAdmin;
	}
	
	public default void fallbackMethodForDeleteAdminById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default AdminModel commonfallbackMethod(AdminModel admin, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		AdminModel fallbackAdmin = new AdminModel(0,"Fall Back Admin", "Application Down", "Error");
		return fallbackAdmin;
	}
	
	public default AdminModel fallbackMethodForAdminLogin(AdminModel admin, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		AdminModel fallbackAdmin = new AdminModel(0, "Fall Back Admin", "Application Down", "Error");
		return fallbackAdmin;
	}
	
	
	
	

}
