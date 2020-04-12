package com.hibernate.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.hibernate.inheritance.tableperclass.Vehicle1;

@Entity
@Table(name="Bike2")
@PrimaryKeyJoinColumn(name="empId")
public class Bike2 extends Vehicle2 {

	@Column
	private int distancecovered;

	public Bike2(String vehiclename, int milage, int distancecovered) {
		super(vehiclename, milage);
		this.distancecovered = distancecovered;
	}

	public int getDistancecovered() {
		return distancecovered;
	}

	public void setDistancecovered(int distancecovered) {
		this.distancecovered = distancecovered;
	}
	
}
