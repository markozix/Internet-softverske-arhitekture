package com.marko.singi.restIspit;

public class DockedBoatHelp {
	
	private String boatName;
	private String dockName;
	private int capacity;
	private boolean full;
	private String capName;
	
	public DockedBoatHelp(String boatName, String dockName, int capacity, boolean full, String capName) {
		super();
		this.boatName = boatName;
		this.dockName = dockName;
		this.capacity = capacity;
		this.full = full;
		this.capName = capName;
	}
	
	public String getBoatName() {
		return boatName;
	}
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	public String getDockName() {
		return dockName;
	}
	public void setDockName(String dockName) {
		this.dockName = dockName;
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
	public String getCapName() {
		return capName;
	}
	public void setCapName(String capName) {
		this.capName = capName;
	}
	@Override
	public String toString() {
		return "DockedBoatHelp [boatName=" + boatName + ", dockName=" + dockName + ", capacity=" + capacity
				+ ", isFull=" + full + ", capName=" + capName + "]";
	}
	
	

}
