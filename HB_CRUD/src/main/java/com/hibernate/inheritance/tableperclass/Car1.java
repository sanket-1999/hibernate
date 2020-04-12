package com.hibernate.inheritance.tableperclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hibernate.inheritance.singletable.Vehicle;

@Entity
@Table(name="car1")
public class Car1 extends Vehicle1 {

	@Column
	private int useryear;

	public Car1(String vehiclename, int milage, int useryear) {
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
