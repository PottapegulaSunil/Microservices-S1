package com.payroll.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="salary")
public class Salary {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="empid")
		private Integer empid;
		
		@Column(name="name")
		private String name;
		
		@Column(name="date")
		private String date;
		
		@Column(name="month")
		private String month;
		
		@Column(name="amount")
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

