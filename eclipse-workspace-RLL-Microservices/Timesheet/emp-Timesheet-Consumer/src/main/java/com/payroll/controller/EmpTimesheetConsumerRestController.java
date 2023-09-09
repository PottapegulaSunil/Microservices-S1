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

import com.payroll.entity.Timesheet;
import com.payroll.proxy.EmployeeTimesheetProxy;

@RestController
@Scope("request")
public class EmpTimesheetConsumerRestController {
	
	@Autowired
	private EmployeeTimesheetProxy emptimesheetproxy;
	
	private Logger log = LoggerFactory.getLogger(EmpTimesheetConsumerRestController.class);
	
	@GetMapping("/get-timesheet/{id}")
	public Timesheet getTimesheetById(@PathVariable("id") int id) {
	
		log.debug("In getTimesheetById with Id: " + id);
		Timesheet timesheet = emptimesheetproxy.getTimesheetById(id);
		log.debug("In getTimesheetById with return value Timesheet: " + timesheet);
		return timesheet;
	}

	@GetMapping("/get-timesheets")
	public List<Timesheet> getAlltimesheets() {
	
		List<Timesheet> Timesheet = emptimesheetproxy.getAllTimesheets();
		log.debug("In getAllTimesheets with return value Timesheets: " + Timesheet);
		return Timesheet;
		
	}
	
	@DeleteMapping("/delete-timesheet/{id}")
	public void deleteTimesheetById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete an Timesheet with Id: " + id);
		emptimesheetproxy.deleteTimesheetById(id);
	}
	
	@PostMapping("/add-timesheet")
	public Timesheet addTimesheet(@RequestBody Timesheet timesheet) {
		log.debug("Request recieved to add an Timesheet: " + timesheet);
		return emptimesheetproxy.addTimesheet(timesheet);
	}
	
	@PutMapping("/update-timesheet")
	public Timesheet updateTimesheet(@RequestBody Timesheet timesheet) {
		log.debug("Request recieved to update an Timesheet: " + timesheet);
		return emptimesheetproxy.updateTimesheet(timesheet);
	}
	

	@GetMapping("/get-timesheet/empid/{empid}")
	public List<Timesheet> getAlltimesheetsOfOneEmployee(@PathVariable("empid") Integer empid) {
	
		List<Timesheet> Timesheet = emptimesheetproxy.getAllTimesheetsOfOneEmployee(empid);
		log.debug("In getAllTimesheetsOfOneEmployee with return value Timesheets: " + Timesheet);
		return Timesheet;
	
	}
	
}
