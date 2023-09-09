package com.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.payroll.entity.Employee;
import com.payroll.repository.EmployeeRepository;

@Service
@Scope(value ="singleton")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee login(String email, String password) {
        if (employeeRepository.findByEmailAndPassword(email, password) != null) {
            return employeeRepository.findByEmail(email);
        }
        return new Employee();
	}


	
	

}
