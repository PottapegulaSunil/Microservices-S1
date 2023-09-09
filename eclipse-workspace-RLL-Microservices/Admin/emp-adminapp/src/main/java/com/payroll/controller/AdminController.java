package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.payroll.entity.AdminModel;
import com.payroll.service.AdminService;

@RestController
@Scope(value = "request")
public class AdminController {
	
	@Autowired
	@Qualifier(value = "adminService")
	private AdminService adminService;
	
	private Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping(value = "/admin", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public AdminModel addAdmin(@RequestBody AdminModel admin) {
		log.debug("Received a request to add an admin: " + admin);
		AdminModel addedAdmin = adminService.addAdmin(admin);
		log.info("AdminModel added: ", addedAdmin);
		return addedAdmin;
	}
	
	@PutMapping(value = "/admin", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public AdminModel updateAdmin(@RequestBody AdminModel admin) {
		log.debug("Received a request to update an admin: " + admin);
		AdminModel updatedAdmin = adminService.updateAdmin(admin);
		log.info("AdminModel updated: ", updatedAdmin);
		return updatedAdmin;
	}
	
	@DeleteMapping(value = "/admin/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAdminById(@PathVariable("id") Integer id) {
		log.debug("Received a request to delete an admin with id: " + id);
		adminService.deleteAdminById(id);
		log.info("AdminModel deleted with id: ", id);
	}
	
	@GetMapping(value = "/admin/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public AdminModel getAdminById(@PathVariable("id") Integer id) {
		log.debug("Received a request to get an admin with id: " + id);
		AdminModel adminById = adminService.getAdminById(id);
		log.info("Return Value: ", adminById);
		return adminById;
	}
	
	@GetMapping(value = "/admins", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AdminModel> getAllAdmins() {
		log.debug("Received a request to view all admin");
		 List<AdminModel> allAdmins = adminService.getAllAdmins();
		 log.info("All Admins Return Value: " + allAdmins);
		 return allAdmins;
		
	}
	
	@PostMapping(value="/admin/login",  produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
    public AdminModel Adminlogin(@RequestBody AdminModel admin){
		log.debug("Received a login Request: " + admin);
        AdminModel AdminLogin = adminService.login(admin.getEmail(), admin.getPassword());
        log.info("Return Value for AdminModel login: " + AdminLogin);
        return AdminLogin;
    }

}
