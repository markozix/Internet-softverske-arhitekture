package com.marko.singi.restIspit2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	private String name;
	private String manufacturer;
	
	private double hp;
	private String type;
	
	public Car() {}
	
	public Car(String name, String manufacturer, double hp, String type) {
		super();
		this.setName(name);
		this.setHp(hp);
		this.setManufacturer(manufacturer);
		this.setType(type);
		
	}

	public Car(int id, String name, String manufacturer, double hp, String type) {
		super();
		this.setId(id);
		this.setName(name);
		this.setHp(hp);
		this.setManufacturer(manufacturer);
		this.setType(type);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", hp=" + hp + ", type=" + type
				+ "]";
	}
}
