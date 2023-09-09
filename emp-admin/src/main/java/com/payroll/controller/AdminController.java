package com.payroll.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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
import org.springframework.web.bind.annotation.RestController;

import com.payroll.domain.AdminModel;
import com.payroll.service.AdminService;

@RestController
@Scope(value ="request")
public class AdminController {
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	

	@PostMapping(value ="/admin" ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public AdminModel addAdmin(@RequestBody AdminModel admin) {
		return adminService.addAdmin(admin);
		
	}
	
	
	@PutMapping(value ="/admin" ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public AdminModel updateAdmin(@RequestBody AdminModel admin) {
		return adminService.updateAdmin(admin);
		
	}


	@DeleteMapping(value ="/admin/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") int id) {
		
		adminService.deleteAdminById(id);
	}
	
	@GetMapping(value ="/admin/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public AdminModel getAdminById(@PathVariable("id") int id) {
		
		 return adminService.getAdminById(id);
	}
	
	@GetMapping(value ="/admins",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AdminModel> getAllAdmins() {
		
		return adminService.getAllAdmins();
	}

	@PostMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> login(@RequestBody AdminModel adminUser) {
	    String email = adminUser.getEmail();
	    String password = adminUser.getPassword();

	    // Retrieve user details from the database
	    AdminModel admin = adminService.findAdminByEmail(email);
        if (admin == null) {
            return ResponseEntity.badRequest().body("Admin not found.");
        }

        //// Validate admin email and password
        if (admin == null || !admin.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

	    // Successful authentication
	     return ResponseEntity.ok("Login successful.");
	}
	

    @PostMapping(value="/register", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> register(@RequestBody AdminModel adminUser) {
        String email = adminUser.getEmail();
        String password = adminUser.getPassword();

        // Perform server-side validation
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Email and password are required.");
        }
        
     // Validate email format using regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            return ResponseEntity.badRequest().body("Invalid email format.");
        }

        // Validate password complexity using regex
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        if (!password.matches(passwordRegex)) {
            return ResponseEntity.badRequest().body("Password must meet complexity requirements.");
        }
        
        
        // Create a new Admin object and set the properties
        AdminModel newAdmin = new AdminModel();
        newAdmin.setEmail(email);
        newAdmin.setPassword(password);

        // Save the new admin user to the database
        adminService.addAdmin(newAdmin);

     
        return ResponseEntity.ok("Admin user registered successfully.");
    }
	
}
	

