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

import com.payroll.entity.Attendance;
import com.payroll.proxy.EmployeeAttendanceProxy;

@RestController
@Scope("request")
public class EmpAttendanceConsumerRestController {
	
	@Autowired
	private EmployeeAttendanceProxy empattendanceproxy;
	
	private Logger log = LoggerFactory.getLogger(EmpAttendanceConsumerRestController.class);
	
	@GetMapping("/get-attendance/{id}")
	public Attendance getAttendanceById(@PathVariable("id") int id) {
	
		log.debug("In getAttendanceById with Id: " + id);
		Attendance attendance = empattendanceproxy.getAttendanceById(id);
		log.debug("In getAttendanceById with return value Attendance: " + attendance);
		return attendance;
	}

	@GetMapping("/get-attendances")
	public List<Attendance> getAllattendances() {
	
		List<Attendance> Attendance = empattendanceproxy.getAllAttendances();
		log.debug("In getAllAttendances with return value Attendances: " + Attendance);
		return Attendance;
		
	}
	
	@DeleteMapping("/delete-attendance/{id}")
	public void deleteAttendanceById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete an Attendance with Id: " + id);
		empattendanceproxy.deleteAttendanceById(id);
	}
	
	@PostMapping("/add-attedance")
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		log.debug("Request recieved to add an Attendance: " + attendance);
		return empattendanceproxy.addAttendance(attendance);
	}
	
	@PutMapping("/update-attendance")
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		log.debug("Request recieved to update an Attendance: " + attendance);
		return empattendanceproxy.updateAttendance(attendance);
	}
	

	@GetMapping("/get-attendance/empid/{empid}")
	public List<Attendance> getAllattendancesOfOneEmployee(@PathVariable("empid") Integer empid) {
	
		List<Attendance> Attendance = empattendanceproxy.getAllAttendancesOfOneEmployee(empid);
		log.debug("In getAllAttendancesOfOneEmployee with return value Attendances: " + Attendance);
		return Attendance;
	
	}
	
}
