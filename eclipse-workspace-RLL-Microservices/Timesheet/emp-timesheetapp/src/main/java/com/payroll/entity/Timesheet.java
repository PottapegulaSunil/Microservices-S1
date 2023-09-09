package com.payroll.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer empid;
    private String name;
    private String date;
    private String intime;
    private String outime;
    private String activity;

    // Constructors

    public Timesheet() {
    }

    public Timesheet(Integer empid, String name, String date, String intime, String outime, String activity) {
        this.empid = empid;
        this.name = name;
        this.date = date;
        this.intime = intime;
        this.outime = outime;
        this.activity = activity;
    }

    // Getter and Setter methods

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

   
    }