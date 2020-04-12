package com.hibernate.inheritance.tableperclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="vehicle1")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle1 {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long vehicleid;

	@Column(name="vehiclename")
	private String vehiclename;
	
	@Column(name="milage")
	private int milage;

	public Vehicle1() {
		
	}
	
	public Vehicle1(String vehiclename, int milage) {
		this.vehiclename = vehiclename;
		this.milage = milage;
	}

	public Long getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(Long vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public double getSal() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}
	public String toString() {
		return vehicleid + " - " + vehiclename + " - " + milage;
	}
	
}
/*
CREATE TABLE EMPLOYEE (ID NUMBER(4) PRIMARY KEY, NAME VARCHAR2(15), SAL NUMBER(7,2), 
	DEPARTMENT_ID NUMBER(4) NOT NULL,
	CONSTRAINT FK_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID))
	 
*/