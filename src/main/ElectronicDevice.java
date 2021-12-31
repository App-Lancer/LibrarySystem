//$Id$
package main;

/**
 * @author Shushanna Bailey
 * This is the class of ElectronicDevice class
 * The class contains the specific attributes of the electronic device class
 * The class contains the getters and setters method for the attributes of the electronic device class
 * The electronic device class represents the electronic device class of a library*/
public class ElectronicDevice {
	
	/**
	 * Unique device id that can be used to identify a unique devices in the library*/
	private int deviceId;
	
	/**
	 * device name of the library device name*/
	private String deviceName;
	
	/**
	 * device description of the library device name*/
	private String deviceDescription;
	
	/**
	 * To store the location of the device in the library*/
	private String location;
	
	/**
	 * To store the device type of the device in the library*/
	private String deviceType;
	
	/**
	 * To store the of the device availability*/
	private boolean isAvailable;
	
	/**
	 * A static variable to hold the next id of the device that needs to be added*/
	private static int nextDeviceId = 0;
	
	/**
	 * Constructor class of ElectronicDevice class
	 * @param deviceName - device name
	 * @param deviceDescription - device description
	 * @param location - device location
	 * @param deviceType - device Type
	 * @param isAvailable - availability of the device*/
	public ElectronicDevice(String deviceName, String deviceDescription, String location, String deviceType, boolean isAvailable) {
		this.deviceId = nextDeviceId++;
		this.deviceName = deviceName;
		this.deviceDescription = deviceDescription;
		this.location = location;
		this.deviceType = deviceType;
		this.isAvailable = isAvailable;
	}
	
	/**
	 * Getter method for device ID
	 * @return int - device id*/
	public int getDeviceId() {
		return this.deviceId;
	}
	
	/**
	 * setter method for device id
	 * @param deviceId - device id*/
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * Getter method for device name
	 * @return String - device name*/
	public String getDeviceName() {
		return this.deviceName;
	}
	
	/**
	 * setter method for device name
	 * @param deviceName - device name string*/
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	/**
	 * getter method for device description
	 * @return String - device description*/
	public String getDeviceDescription() {
		return this.deviceDescription;
	}
	
	/**
	 * setter method for device description
	 * @param deviceDescription - device description of the device*/
	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}
	
	/**
	 * getter method for location
	 * @return String - location description of the device*/
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * setter method for location
	 * @param location - location description of the device*/
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * getter method for availability
	 * @return boolean - availability of the device*/
	public boolean getAvailability() {
		return this.isAvailable;
	}
	
	/**
	 * setter method for availability
	 * @param isAvailable - available status value of the device*/
	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/**
	 * To toggle the availability of the device*/
	public void toggleAvailability() {
		this.isAvailable = !this.isAvailable;
	}
	
	/**
	 * getter method for device type
	 * @return String - device type of the device*/
	public String getDeviceType() {
		return this.deviceType;
	}
	
	/**
	 * setter method for device type
	 * @param deviceType - device type of the device*/
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	/**
	 * To get the details of the electronic device
	 * @return String - String containing the values of the electronic devices*/
	public String getDetails() {
		String returnVal = "Device ID : "+ this.deviceId +"\n"
				+ "Device name : "+ this.deviceName +"\n"
				+ "Device Description : "+ this.deviceDescription +"\n"
				+ "Location : "+ this.location +"\n"
				+ "Device Type : "+ this.deviceType +"\n"
				+ "Availability : "+ (this.isAvailable ? "Device is available" : "Device is currently in use") +"\n";
		return returnVal;
	}
	
	/**
	 * To checks if both the device objects are equal
	 * The id of both the objects are equal
	 * @return boolean - return boolean value of equality of 2 device objects*/
	public boolean isEqual(ElectronicDevice eleDevice2) {
		if(eleDevice2 == null) return false;
		return this.deviceId == eleDevice2.getDeviceId();
	}
	
	/**
	 * To print the details of the electronic devices*/
	public void printDetails() {
		System.out.println(getDetails());
	}
}
