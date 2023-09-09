package com.payroll.service;

import java.util.List;

import com.payroll.entity.Salary;

public interface SalaryService {
	
	public Salary addSalary(Salary salary);
	public Salary updateSalary(Salary salary);
	public List<Salary> getAllSalarys();
	public Salary getSalaryById(Integer id);
	//public void deleteSalaryById(Integer id);
	
	public List<Salary> findByEmpid(Integer empid);
	
	
}

