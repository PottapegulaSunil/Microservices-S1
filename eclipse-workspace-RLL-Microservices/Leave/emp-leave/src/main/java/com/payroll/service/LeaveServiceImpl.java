package com.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.payroll.entity.Leave;
import com.payroll.repository.LeaveRepository;

@Service(value = "leaveService")
@Scope("singleton")

public class LeaveServiceImpl implements LeaveService  {
	
	@Autowired
	@Qualifier(value = "leaveRepository")
	private LeaveRepository leaveRepository;
  
	@Override
	public Leave addLeave(Leave leave) {
		
		return leaveRepository.save(leave);
	}

	@Override
	public List<Leave> getAllLeave() {
		
		return leaveRepository.findAll();
	}

	@Override
	public void deleteLeaveById(int id) {
		leaveRepository.deleteById(id);
		
	}

	@Override
	public Leave updateLeave(Leave leave) {

		return leaveRepository.save(leave);

	}

	@Override
	public Leave getLeaveByid(int id) {
		return leaveRepository.findById(id).get();
	}

	@Override
	public List<Leave> getAllLeaveOfOneEmployee(Integer empid) {
		// TODO Auto-generated method stub
		return leaveRepository.findByEmpid(empid);
	}

}
