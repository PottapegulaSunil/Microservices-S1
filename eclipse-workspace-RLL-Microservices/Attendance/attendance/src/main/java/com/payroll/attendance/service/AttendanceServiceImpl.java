package com.payroll.attendance.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import com.payroll.attendance.entity.Attendance;
import com.payroll.attendance.respository.AttendanceRespository;


@Service(value="attendanceService")
@Scope(value="singleton")
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	//@Qualifier(value="attendanceRepository")
	private AttendanceRespository attendanceRepository;

	@Override
	public Attendance addattendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateattendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceRepository.save(attendance);
	}

	@Override
	public List<Attendance> getAllattendance() {
		// TODO Auto-generated method stub
		return attendanceRepository.findAll();
	}

	@Override
	public Attendance getattendanceById(Integer id) {
		// TODO Auto-generated method stub
		return attendanceRepository.findById(id).get();
	}

	@Override
	public void deleteattendanceById(Integer id) {
		// TODO Auto-generated method stub
		attendanceRepository.deleteById(id);
	}

	@Override
	public List<Attendance> getAllattendanceOfOneEmployee(Integer empid) {
		// TODO Auto-generated method stub
		return attendanceRepository.findByEmpid(empid);
	}

	

	

	


}
