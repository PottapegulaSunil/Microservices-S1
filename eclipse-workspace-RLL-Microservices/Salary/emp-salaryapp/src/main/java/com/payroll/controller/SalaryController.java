package com.payroll.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.Salary;
import com.payroll.service.SalaryService;

@RestController
@Scope(value = "request")
public class SalaryController {
	
	@Autowired
	@Qualifier(value="salaryService")
	private SalaryService salaryService;
	
	
	@PostMapping(value = "/salary", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Salary addSalary(@RequestBody Salary salary){
		return salaryService.addSalary(salary);
	}
	
	@PutMapping(value = "/salary", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Salary updateESalary(@RequestBody Salary salary) {
		return salaryService.updateSalary(salary);
	}
	
	/**
	@DeleteMapping(value = "/salary/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteSalaryById(@PathVariable("id") Integer id) {
		salaryService.deleteSalaryById(id);
	}
	**/
	
	
	@GetMapping(value = "/salary/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Salary getSalaryById(@PathVariable("id") Integer id) {
		return salaryService.getSalaryById(id);
	}
	
	@GetMapping(value = "/salaries", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Salary> getAllSalarys() {
		return salaryService.getAllSalarys();
	}
	
	
	@GetMapping(value = "/salary/empid/{empid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Salary> findByEmpid(@PathVariable("empid") Integer empid) {
        return salaryService.findByEmpid(empid);
    }

}
