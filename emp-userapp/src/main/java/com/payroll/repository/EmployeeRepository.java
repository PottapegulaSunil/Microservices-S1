package com.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.Employee;

@Repository(value="employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
    Employee findByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);

}
