package com.payroll.service;


import java.util.List;

import com.payroll.domain.AdminModel;


public interface AdminService  {

	public AdminModel addAdmin(AdminModel admin);
	public AdminModel updateAdmin(AdminModel admin);
	public List<AdminModel> getAllAdmins();
	public AdminModel getAdminById(int id);
	public void deleteAdminById(int id);
	
	public AdminModel findAdminByEmail(String email);

}
