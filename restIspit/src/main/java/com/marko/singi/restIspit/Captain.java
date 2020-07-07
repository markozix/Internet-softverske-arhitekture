package com.marko.singi.restIspit;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Captain {
	
	@Id
	private int captain_id;
	
	private String name;
	private String experience;
	
	public Captain() {
	}

	public Captain(String name, String experience) {
		super();
		this.setName(name);
		this.setExperience(experience);
	}

	public Captain(int id, String name, String experience) {
		super();
		this.setCaptain_id(id);
		this.setName(name);
		this.setExperience(experience);
	}



	public int getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(int captain_id) {
		this.captain_id = captain_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Captain [captain_id=" + captain_id + ", name=" + name + ", experience=" + experience + "]";
	}

	
	
	
	
	
	

}
