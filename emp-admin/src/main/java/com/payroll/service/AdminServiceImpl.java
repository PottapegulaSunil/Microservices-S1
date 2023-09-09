package com.payroll.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import com.payroll.domain.AdminModel;
import com.payroll.repository.AdminRepository;

@Service (value = "adminService")
@Scope (value = "singleton")
public class AdminServiceImpl implements AdminService{

	@Autowired
	@Qualifier(value = "adminRepository")
	private AdminRepository adminRepository;
	
	@Override
	public AdminModel addAdmin(AdminModel admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public AdminModel updateAdmin(AdminModel admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<AdminModel> getAllAdmins() {
		
		return adminRepository.findAll();
	}

	@Override
	public AdminModel getAdminById(int id) {
		
		return adminRepository.findById(id).get();
	}

	@Override
	public void deleteAdminById(int id) {
		adminRepository.deleteById(id);
		
	}

	@Override
	public AdminModel findAdminByEmail(String email) {
		
		return adminRepository.findAdminByEmail(email);


}
}