package com.payroll.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.payroll.entity.Timesheet;
import com.payroll.service.TimesheetService;

import java.util.List;

@RestController
@Scope(value = "request")
public class TimesheetController {
	
	@Autowired
	private  TimesheetService  timesheetService;
	
	@PostMapping(value = "/timesheet", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public  Timesheet addTimesheet(@RequestBody  Timesheet  timesheet) {
		return  timesheetService.addTimesheet(timesheet);
	}
	
	@PutMapping(value = "/timesheet", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public  Timesheet updateTimesheet(@RequestBody  Timesheet timesheet) {
		return  timesheetService.updateTimesheet(timesheet);
	}
	
	@DeleteMapping(value = "/timesheet/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTimesheetById(@PathVariable("id") Integer id) {
		 timesheetService.deleteTimesheetById(id);
	}
	
	@GetMapping(value = "/timesheet/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public  Timesheet getTimesheetById(@PathVariable("id") Integer id) {
		return  timesheetService.getTimesheetById(id);
	}
	
	@GetMapping(value = "/timesheets", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Timesheet> getAllTimesheets() {
		return  timesheetService.getAllTimesheet();
	}
	
	@GetMapping(value = "/timesheet/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Timesheet> getAllTimesheetsOfOneEmployee(@PathVariable("empid") Integer empid) {
		return timesheetService.getAllTimesheetOfOneEmployee(empid);
	}
	
	
}