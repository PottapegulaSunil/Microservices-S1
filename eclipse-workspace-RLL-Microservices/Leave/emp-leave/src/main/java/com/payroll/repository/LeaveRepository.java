package com.payroll.repository;


import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.Leave;
@Repository(value = "leaveRepository")
@Scope("singleton")
public interface  LeaveRepository extends JpaRepository <Leave,Integer> {
	List<Leave> findByEmpid (Integer empid);
}
