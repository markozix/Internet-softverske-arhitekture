package com.marko.singi.restIspit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boat {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private int captain_id;

	public Boat() {
		super();
	}



	public Boat(String name, int captain_id) {
		super();
		this.setName(name);
		this.setCaptain_id(captain_id);
	}



	public Boat(int id, String name, int captain_id) {
		super();
		this.setId(id);
		this.setName(name);
		this.setCaptain_id(captain_id);
	}



	public int getCaptain_id() {
		return captain_id;
	}



	public void setCaptain_id(int captain_id) {
		this.captain_id = captain_id;
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



	@Override
	public String toString() {
		return "Boat [id=" + id + ", name=" + name + ", captain_id=" + captain_id + "]";
	}

	
	
	

}
