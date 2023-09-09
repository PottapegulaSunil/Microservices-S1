package com.payroll.attendance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.payroll.attendance.entity.Attendance;
import com.payroll.attendance.service.AttendanceService;



@RestController
@Scope(value = "request")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	private Logger log = LoggerFactory.getLogger(AttendanceController.class);
	
	@PostMapping(value = "/attendance", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Attendance addattendance(@RequestBody Attendance attendance ) {
		return attendanceService.addattendance(attendance);
	}
	
	@PutMapping(value = "/attendance", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Attendance updateattendance(@RequestBody Attendance attendance) {
		return attendanceService.updateattendance(attendance);
	}
	
	@DeleteMapping(value = "/attendance/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteattendanceById(@PathVariable("id") Integer id) {
		attendanceService.deleteattendanceById(id);
	}
	
	@GetMapping(value = "/attendance/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Attendance getattendanceById(@PathVariable("id") Integer id) {
		return attendanceService.getattendanceById(id);
	}
	
	@GetMapping(value = "/attendances", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Attendance> getAllAttendance() {
		return attendanceService.getAllattendance();
	}
	
	@GetMapping(value = "/attendance/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Attendance> getAllAttendancesOfOneEmployee(@PathVariable("empid") Integer empid) {
		return attendanceService.getAllattendanceOfOneEmployee(empid);
	}
}