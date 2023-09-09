package com.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.payroll.entity.AdminModel;


@Repository(value="adminRepository")
public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
	
    AdminModel findByEmailAndPassword(String email, String password);

    AdminModel findByEmail(String email);
    

}
