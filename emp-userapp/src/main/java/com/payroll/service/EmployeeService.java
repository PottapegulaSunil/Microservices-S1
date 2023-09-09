package com.payroll.service;

import java.util.List;

import com.payroll.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee (Employee employee);
	public Employee updateEmployee (Employee employee);
	public List<Employee> getAllEmployees ();
	public Employee getEmployeeById (Integer id);
	public void deleteEmployeeById (Integer id);
	
    public Employee login(String email, String password);
    //public Employee findByEmail(String email);

}
