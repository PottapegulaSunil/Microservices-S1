package com.payroll.entity;

public class Salary {

	private Integer id;
	private Integer empid;
	private String name;
	private String date;
	private String month;
	private Integer amount;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Salary(Integer id, Integer empid, String name, String date, String month, Integer amount) {
		super();
		this.id = id;
		this.empid = empid;
		this.name = name;
		this.date = date;
		this.month = month;
		this.amount = amount;
	}
	
	public Salary() {
		super();
	}
	
	
	
	
	
	
}

	

