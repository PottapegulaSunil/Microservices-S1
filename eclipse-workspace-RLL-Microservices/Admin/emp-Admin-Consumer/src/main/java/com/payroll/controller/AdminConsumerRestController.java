package com.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.AdminModel;
import com.payroll.proxy.AdminUserProxy;

@RestController
@Scope("request")
public class AdminConsumerRestController {

    @Autowired
    private AdminUserProxy adminuserproxy;

    private Logger log = LoggerFactory.getLogger(AdminConsumerRestController.class);

    @GetMapping("/get-admin/{id}")
    public AdminModel getAdminById(@PathVariable("id") int id) {
        log.debug("In getAdminById with Id: " + id);
        AdminModel admin = adminuserproxy.getAdminById(id);
        log.debug("In getAdminById with return value Admin: " + admin);
        return admin;
    }

    @GetMapping("/get-admins")
    public List<AdminModel> getAllAdmins() {
        List<AdminModel> admins = adminuserproxy.getAllAdmins();
        log.debug("In getAllAdmins with return value admins: " + admins);
        return admins;
    }

    @DeleteMapping("/delete-admin/{id}")
    public void deleteAdminById(@PathVariable("id") Integer id) {
        log.debug("Request received to delete an Admin with Id: " + id);
        adminuserproxy.deleteAdminById(id);
    }

    @PostMapping("/add-admin")
    public AdminModel addAdmin(@RequestBody AdminModel admin) {
        log.debug("Request received to add an Admin: " + admin);
        return adminuserproxy.addAdmin(admin);
    }

    @PutMapping("/update-admin")
    public AdminModel updateAdmin(@RequestBody AdminModel admin) {
        log.debug("Request received to update an Admin: " + admin);
        return adminuserproxy.updateAdmin(admin);
    }

    @PostMapping("/login-admin")
    public AdminModel Adminlogin(@RequestBody AdminModel admin) {
        log.debug("Login Request received with credentials: " + admin);
        return adminuserproxy.adminLogin(admin);
    }
}
