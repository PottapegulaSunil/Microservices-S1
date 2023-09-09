package com.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.entity.Timesheet;
import com.payroll.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements TimesheetService{
   
	@Autowired
    private TimesheetRepository timesheetRepository;
	@Override
	public Timesheet addTimesheet(Timesheet timesheet) {
		// TODO Auto-generated method stub
		return timesheetRepository.save(timesheet);
	}

	@Override
	public Timesheet updateTimesheet(Timesheet timesheet) {
		// TODO Auto-generated method stub
		return timesheetRepository.save(timesheet);
	}

	@Override
	public List<Timesheet> getAllTimesheet() {
		// TODO Auto-generated method stub
		return (List<Timesheet>) timesheetRepository.findAll();
	}

	@Override
	public Timesheet getTimesheetById(Integer id) {
		// TODO Auto-generated method stub
		return timesheetRepository.findById(id).get();
	}

	@Override
	public void deleteTimesheetById(Integer id) {
		// TODO Auto-generated method stub
		timesheetRepository.deleteById(id);
	}

	@Override
	public List<Timesheet> getAllTimesheetOfOneEmployee(Integer empid) {
		// TODO Auto-generated method stub
		return timesheetRepository.findByEmpid(empid);
	}
	

}