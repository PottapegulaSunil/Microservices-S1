package com.payroll.entity;

public class Attendance {

	private Integer id;
	
	
	private Integer empid;
	
	
	private String name;
	
	
	private String email;
	
	
	private String date;
	
	
	private String status;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Attendance(Integer id, Integer empid, String name, String email, String date, String status) {
		super();
		this.id = id;
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.date = date;
		this.status = status;
	}


	public Attendance() {
		super();
	}


	@Override
	public String toString() {
		return "Attendance [id=" + id + ", empid=" + empid + ", name=" + name + ", email=" + email + ", date=" + date
				+ ", status=" + status + "]";
	}
	
	
}
