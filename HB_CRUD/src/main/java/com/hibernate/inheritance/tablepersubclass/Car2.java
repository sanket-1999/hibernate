package com.hibernate.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.hibernate.inheritance.tableperclass.Vehicle1;

@Entity
@Table(name="car2")
@PrimaryKeyJoinColumn(name="empId")
public class Car2 extends Vehicle2 {

	@Column
	private int useryear;

	public Car2(String vehiclename, int milage, int useryear) {
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
