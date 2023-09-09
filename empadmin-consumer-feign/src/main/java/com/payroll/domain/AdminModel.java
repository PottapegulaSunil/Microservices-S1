package com.payroll.domain;




public class AdminModel {
	
	
	private int id ;
	
	private String email;
	
	private String admin_name;
	
	private String password;
    
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    //Constructor with fields
	public AdminModel(int id, String email, String admin_name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.admin_name = admin_name;
		this.password = password;
	}
    //Constructor without fields

	public AdminModel() {
		
	}
	
    //toString Method
	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", email=" + email + ", admin_name=" + admin_name + ", password=" + password
				+ "]";
	}
	
	

}
