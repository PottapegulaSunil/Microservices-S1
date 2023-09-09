package com.payroll.repository;
import org.springframework.data.repository.CrudRepository;

import com.payroll.entity.Timesheet;

import java.util.List;

public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {
    List<Timesheet> findByEmpid(Integer empid);
}