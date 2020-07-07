package com.marko.singi.restIspit;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Dock {
	@Id
	private int dock_id;
	
	private String name;
	private int capacity;

	private boolean full;
	
	public Dock() {
		
	}
	
	public Dock(int dock_id, String name, int capacity, boolean full) {
		super();
		this.setDock_id(dock_id);
		this.setCapacity(capacity);
		this.setFull(full);
		this.setName(name);
	}
	
	public Dock(String name, int capacity, boolean full) {
		super();
		this.setCapacity(capacity);
		this.setFull(full);
		this.setName(name);
	}

	public int getDock_id() {
		return dock_id;
	}
	public void setDock_id(int dock_id) {
		this.dock_id = dock_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	@Override
	public String toString() {
		return "Dock [dock_id=" + dock_id + ", name=" + name + ", capacity=" + capacity + ", full=" + full + "]";
	}

	
	

}
