package com.payroll.repository;

import org.springframework.context.annotation.Scope;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.domain.AdminModel;

@Repository (value = "adminRepository")
@Scope(value = "singleton")
public interface AdminRepository extends JpaRepository<AdminModel , Integer>{
	
	public AdminModel findAdminByEmail(String email);

}
