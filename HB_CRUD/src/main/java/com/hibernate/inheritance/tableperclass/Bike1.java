package com.hibernate.inheritance.tableperclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="Bike1")
public class Bike1 extends Vehicle1 {

	@Column
	private int distancecovered;

	public Bike1(String vehiclename, int milage, int distancecovered) {
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
