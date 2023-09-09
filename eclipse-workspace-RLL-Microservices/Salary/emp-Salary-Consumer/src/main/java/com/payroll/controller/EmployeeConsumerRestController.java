package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.Salary;
import com.payroll.proxy.EmployeeSalaryProxy;

@RestController
@Scope("request")
public class EmployeeConsumerRestController {
	
	@Autowired
	private EmployeeSalaryProxy empsalaryproxy;
	
	private Logger log = LoggerFactory.getLogger(EmployeeConsumerRestController.class);
	
	@GetMapping("/get-salary/{id}")
	public Salary getSalaryById(@PathVariable("id") int id) {
	
		log.debug("In getSalaryById with Id: " + id);
		Salary salary = empsalaryproxy.getSalaryById(id);
		log.debug("In getSalaryById with return value Salary: " + salary);
		return salary;
	}

	@GetMapping("/get-salaries")
	public List<Salary> getAllSalarys() {
	
		List<Salary> salarys = empsalaryproxy.getAllSalarys();
		log.debug("In getAllSalarys with return value Salarys: " + salarys);
		return salarys;
		
	}
	
	
	@PostMapping("/add-salary")
	public Salary addSalary(@RequestBody Salary salary) {
		log.debug("Request recieved to add an Salary: " + salary);
		return empsalaryproxy.addSalary(salary);
	}

	
	
	@PutMapping("/update-salary")
	public Salary updateSalary(@RequestBody Salary salary) {
		log.debug("Request recieved to update an Salary: " + salary);
		return empsalaryproxy.updateESalary(salary);
	}
	
	@GetMapping("/get-salary/empid/{empid}")
	public List<Salary> findByEmpid(@PathVariable("empid") int empid) {
    	log.debug("In findByEmpid with Id: " + empid);
    	List<Salary> salary = empsalaryproxy.findByEmpid(empid);
    	log.debug("In findByEmpid with return value Salary: " + salary);
    	return salary;
	}
	
  
	
}
