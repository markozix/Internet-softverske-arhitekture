package com.marko.singi.restIspit2;

import javax.persistence.Entity; 
import javax.persistence.Id;

@Entity
public class Testorder {

	@Id
	private int order_id;
	
	private String name;
	private int hp;
	private String manufacturer;
	private String status;

	public Testorder() {
	
	}
	public Testorder(String name, int hp, String manufacturer, String status) {
		super();
		this.setName(name);
		this.setHp(hp);
		this.setManufacturer(manufacturer);
		this.setStatus(status);
	}
	public Testorder(int order_id, String name, int hp, String manufacturer, String status) {
		super();
		this.setName(name);
		this.setHp(hp);
		this.setManufacturer(manufacturer);
		this.setStatus(status);
		this.setOrder_id(order_id);
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", name=" + name + ", hp=" + hp + ", manufacturer=" + manufacturer
				+ ", status=" + status + "]";
	}
	
	
	
	
}
