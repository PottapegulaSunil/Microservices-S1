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

import com.payroll.entity.Leave;
import com.payroll.service.LeaveService;

@RestController
@Scope(value = "request")
public class LeaveController {

	@Autowired
	@Qualifier(value = "leaveService")
	private LeaveService leaveService;

	private Logger log = LoggerFactory.getLogger(LeaveController.class);

	@PostMapping(value = "/leave", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Leave addLeave(@RequestBody Leave leave) {
		log.debug("Request Recieved to apply for leave");
		return leaveService.addLeave(leave);
	}

	@PutMapping(value = "/leave", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Leave updateLeave(@RequestBody Leave leave) {
		log.debug("Request Recieved to update leave parameters");
		return leaveService.updateLeave(leave);
	}

	@DeleteMapping(value = "/leave/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") int id) {
		log.debug("Request Recieved to cancel leave");
		leaveService.deleteLeaveById(id);
	}

	@GetMapping(value = "/leaves", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Leave> getAllLeaves() {
		log.debug("Request Recieved to get all leaves");
		return leaveService.getAllLeave();
	}

	@GetMapping(value = "/leave/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Leave getLeaveById(@PathVariable("id") int id) {
		log.debug("Request Recieved get one leave");
		return leaveService.getLeaveByid(id);
	}

	@GetMapping(value = "/leave/empid/{empid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Leave> getAllLeaveOfOneEmployee(@PathVariable("empid") Integer empid) {
		log.debug("Request Recieved to get all leaves of one employee");
		return leaveService.getAllLeaveOfOneEmployee(empid);
	}
}
