package com.marko.singi.restIspit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DockedBoat {

	@Id
	private int docked_id;
	
	private int boat_id;
	private int dock_id;
	
	public DockedBoat() {
		
	}

	public DockedBoat(int docked_id, int boat_id, int dock_id) {
		super();
		this.setDocked_id(docked_id);
		this.setBoat_id(boat_id);
		this.setDock_id(dock_id);
	}
	
	public DockedBoat(int boat_id, int dock_id) {
		super();
		this.setBoat_id(boat_id);
		this.setDock_id(dock_id);
	}

	public int getDocked_id() {
		return docked_id;
	}
	public void setDocked_id(int docked_id) {
		this.docked_id = docked_id;
	}
	public int getBoat_id() {
		return boat_id;
	}
	public void setBoat_id(int boat_id) {
		this.boat_id = boat_id;
	}
	public int getDock_id() {
		return dock_id;
	}
	public void setDock_id(int dock_id) {
		this.dock_id = dock_id;
	}

	@Override
	public String toString() {
		return "DockedBoat [docked_id=" + docked_id + ", boat_id=" + boat_id + ", dock_id=" + dock_id + "]";
	}
	
	
	
}
