package com.payroll.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.Salary;

@Repository(value="salaryRepository")
@Scope(value = "singleton")
public interface SalaryRepository extends JpaRepository<Salary, Integer>  {
	
	List<Salary> findByEmpid(Integer empid);
	
}
