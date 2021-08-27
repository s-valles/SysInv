package net.javatec.sysinv.model;

public class Systema {
	
	private int id;
	private String name;
	private String serialNumber;
	private String location;
	
	
	
	public Systema(int id, String name, String serialNumber, String location) {
		super();
		this.id = id;
		this.name = name;
		this.serialNumber = serialNumber;
		this.location = location;
	}
	
	
	
	public Systema(String name, String serialNumber, String location) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.location = location;
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
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
