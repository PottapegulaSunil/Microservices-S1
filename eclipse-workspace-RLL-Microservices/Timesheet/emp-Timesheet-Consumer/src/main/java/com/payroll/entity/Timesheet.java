package com.payroll.entity;

public class Timesheet {
	    
	    private Integer id;
	    private Integer empid;
	    private String name;
	    private String date;
	    private String intime;
	    private String outime;
	    private String activity;
		
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
		public String getIntime() {
			return intime;
		}
		public void setIntime(String intime) {
			this.intime = intime;
		}
		public String getOutime() {
			return outime;
		}
		public void setOutime(String outime) {
			this.outime = outime;
		}
		public String getActivity() {
			return activity;
		}
		public void setActivity(String activity) {
			this.activity = activity;
		}
		public Timesheet(Integer id, Integer empid, String name, String date, String intime, String outime,
				String activity) {
			super();
			this.id = id;
			this.empid = empid;
			this.name = name;
			this.date = date;
			this.intime = intime;
			this.outime = outime;
			this.activity = activity;
		}
		public Timesheet() {
			super();
		}
		@Override
		public String toString() {
			return "Timesheet [id=" + id + ", empid=" + empid + ", name=" + name + ", date=" + date + ", intime="
					+ intime + ", outime=" + outime + ", activity=" + activity + "]";
		}
	    
	    
	    

}
