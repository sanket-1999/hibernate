package com.hibernate.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="car")
public class Car extends Vehicle {

	@Column
	private int useryear;

	public Car(String vehiclename, int milage, int useryear) {
		super(vehiclename, milage);
		this.useryear = useryear;
	}

	public double getUseryear() {
		return useryear;
	}

	public void setUseryear(int useryear) {
		this.useryear = useryear;
	}
	
}
