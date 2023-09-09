package com.payroll.service;

import java.util.List;

import com.payroll.entity.Leave;

 public interface  LeaveService {

	public Leave addLeave(Leave leave);
	
	public List<Leave> getAllLeave();

    public void  deleteLeaveById(int id);
    public Leave updateLeave(Leave leave);
    public Leave getLeaveByid(int id);
    public List<Leave> getAllLeaveOfOneEmployee(Integer empid);

}