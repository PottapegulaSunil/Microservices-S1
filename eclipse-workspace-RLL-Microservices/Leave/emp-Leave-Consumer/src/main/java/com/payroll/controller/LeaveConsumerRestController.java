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
import com.payroll.entity.Leave;
import com.payroll.proxy.EmployeeLeaveProxy;


@RestController
@Scope("request")
public class LeaveConsumerRestController {
	
	@Autowired
	private EmployeeLeaveProxy empleaveproxy;
	
	private Logger log = LoggerFactory.getLogger(LeaveConsumerRestController.class);
	
	@GetMapping("/get-leave/{id}")
	public Leave getLeaveById(@PathVariable("id") int id) {
	
		log.debug("In getLeaveById with Id: " + id);
		Leave leave = empleaveproxy.getLeaveById(id);
		log.debug("In getLeaveById with return value Employee: " + leave);
		return leave;
	}

	@GetMapping("/get-leaves")
	public List<Leave> getAlleaves() {
	
		List<Leave> leaves = empleaveproxy.getAllLeave();
		log.debug("In getAllLeaves with return value Leaves: " + leaves);
		return leaves;
		
	}
	
	@DeleteMapping("/delete-leave/{id}")
	public void deleteLeaveById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete an Leave with Id: " + id);
		empleaveproxy.deleteLeaveById(id);
	}
	
	@PostMapping("/add-leave")
	public  Leave addLeave(@RequestBody Leave leave) {
		log.debug("Request recieved to add an Leave: " + leave);
		return empleaveproxy.addLeave(leave);
	}
	
	@PutMapping("/update-leave")
	public Leave updateLeave(@RequestBody Leave leave) {
		log.debug("Request recieved to update an Leave: " + leave);
		return empleaveproxy.updateLeave(leave);
	}
	
	@GetMapping("/get-leave/empid/{empid}")
	public List<Leave> getAllLeavesOfOneEmployee(@PathVariable("empid") Integer empid) {
	
		List<Leave> Leave = empleaveproxy.getAllLeavesOfOneEmployee(empid);
		log.debug("In getAllLeavesOfOneEmployee with return value Leaves: " + Leave);
		return Leave;
	
	}
	
	
	}
	
	

