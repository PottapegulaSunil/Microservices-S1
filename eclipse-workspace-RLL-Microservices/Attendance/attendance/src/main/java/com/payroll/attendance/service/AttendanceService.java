package com.payroll.attendance.service;

import java.util.List;

import com.payroll.attendance.entity.Attendance;
public interface AttendanceService {
	public Attendance addattendance(Attendance attendance);
	public Attendance updateattendance(Attendance attendance);
	public List<Attendance> getAllattendance();
	public Attendance getattendanceById(Integer id);
	public void deleteattendanceById(Integer id);
	
	
	public List<Attendance> getAllattendanceOfOneEmployee(Integer empid);
}
