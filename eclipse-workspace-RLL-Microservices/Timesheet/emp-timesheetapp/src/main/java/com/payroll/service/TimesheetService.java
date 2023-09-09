package com.payroll.service;

import java.util.List;

import com.payroll.entity.Timesheet;

public interface TimesheetService {
	
	public Timesheet addTimesheet  ( Timesheet   timesheet );
	public  Timesheet  updateTimesheet  ( Timesheet   timesheet );
	public List<Timesheet> getAllTimesheet  ();
	public  Timesheet getTimesheetById (Integer id);
	public void deleteTimesheetById (Integer id);
	
	
	public List<Timesheet> getAllTimesheetOfOneEmployee(Integer empid);
	
}
