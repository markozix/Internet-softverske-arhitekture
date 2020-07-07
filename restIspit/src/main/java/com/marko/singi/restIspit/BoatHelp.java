package com.marko.singi.restIspit;

public class BoatHelp {
	
	private int id;
	private String name;
	private String captain_name;
	private String cap_experience;
	
	
	
	public BoatHelp(int id, String name, String captain_name, String cap_experience) {
		super();
		this.id = id;
		this.name = name;
		this.captain_name = captain_name;
		this.cap_experience = cap_experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaptain_name() {
		return captain_name;
	}
	public void setCaptain_name(String captain_name) {
		this.captain_name = captain_name;
	}
	
	public String getCap_experience() {
		return cap_experience;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCap_experience(String cap_experience) {
		this.cap_experience = cap_experience;
	}
	@Override
	public String toString() {
		return "BoatHelp [name=" + name + ", captain_name=" + captain_name + "]";
	}
	
	

}
