package com.hibernate.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="bike")
public class Bike extends Vehicle {

	@Column
	private int distancecovered;

	public Bike(String vehiclename, int milage, int distancecovered) {
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
