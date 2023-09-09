package com.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.payroll.entity.Salary;
import com.payroll.repository.SalaryRepository;

@Service(value = "salaryService")
@Scope(value = "singleton")
public class SalaryServiceImpl implements SalaryService {


	@Autowired
	@Qualifier(value="salaryRepository")
	private SalaryRepository salaryRepository;

	@Override
	public Salary addSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	@Override
	public Salary updateSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getAllSalarys() {
		return salaryRepository.findAll();
	}

	@Override
	public Salary getSalaryById(Integer id) {
		return salaryRepository.findById(id).get();
	}

	@Override
	public List<Salary> findByEmpid(Integer empid) {
		return salaryRepository.findByEmpid(empid);
	}
	
	
}
