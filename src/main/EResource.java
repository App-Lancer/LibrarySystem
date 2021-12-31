//$Id$
package main;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Shushanna Bailey
 * This is the child class of resource class
 * The class contains the specific attributes of the e-resource class (e-resource book)
 * The class contains the getters and setters method for the attributes of the e-resource class
 * The EResource class represents the e-resource of a library*/
public class EResource extends Resource{
	
	/**
	 * DOI - Digital object identifier value of a EResource book*/
	private String DOI;
	
	/**
	 * published date value of a EResource book*/
	private Date publishedDate;
	
	/**
	 * list of devices that contains the e resource*/
	private ArrayList<ElectronicDevice> electronicDevices;
	
	/**
	 * Constructor class of EResource class
	 * @param title - e-resource title
	 * @param authors - authors of e-resource
	 * @param resourceDescription - short description regarding the e-resource
	 * @param doi - Digital object identifier of the e-resource
	 * @param publishedDate - published date of the e-resource
	 * @param electronicDevices - List of devices that contains the e-resources*/
	public EResource(String title, ArrayList<String> authors, String resourceDescription, String doi, Date publishedDate, ArrayList<ElectronicDevice> electronicDevices) {
		super(title, authors, resourceDescription, "ERESOURCE");
		this.DOI = doi;
		this.publishedDate = publishedDate;
		this.electronicDevices = electronicDevices;
	}

	/**
	 * Getter method for DOI
	 * @return String - DOI data*/
	public String getDOI() {
		return this.DOI;
	}
	
	/**
	 * setter method of DOI
	 * @param doi - digital object identifier of a e-resource*/
	public void setDOI(String doi) {
		this.DOI = doi;
	}
	
	/**
	 * Getter method for published date
	 * @return Date - published date*/
	public Date getPublishedDate() {
		return this.publishedDate;
	}
	
	/**
	 * Setter method for published date
	 * @param publishedDate - published date of a e-resource*/
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	/**
	 * Getter method for electronic devices that contains the e-resource
	 * @return ArrayList<ElectronicDevice> - List of electronic devices that holds the e-resource*/
	public ArrayList<ElectronicDevice> getElectronicDevices(){
		return this.electronicDevices;
	}
	
	/**
	 * setter method for electronic devices
	 * @param ArrayList<ElectronicDevice> - list of devices that holds the e-resource*/
	public void setElectroniceDevices(ArrayList<ElectronicDevice> electronicDevices) {
		this.electronicDevices = electronicDevices;
	}
	
	/**
	 * Add a new electronic device to the electrnoicDevices list
	 * If the electronicDevices array list is null a new ArrayList object will be created and the new object will be added
	 * @param ElectronicDevice - a new electronic device
	 * @return String - To return the message of adding the new device to the list*/
	public String addElectronicDevice(ElectronicDevice electronicDevice) {
		
		if(electronicDevice == null) {
			return "Null value cannot be added";
		}
		
		if(this.electronicDevices == null) {
			this.electronicDevices = new ArrayList<ElectronicDevice>();
			this.electronicDevices.add(electronicDevice);
			return "Device added successfully";
		}else {
			if(!isAlreadyPresentDevice(electronicDevice)) {
				this.electronicDevices.add(electronicDevice);
				return "Device added successfully";
			}else {
				return "Device already contains the resource";
			}
		}
	}
	
	/**
	 * To check if a device already contains the e-resource
	 * If the device is already present in list false will be returned else true will be returned
	 * @param ElectronicDevice - electronic device
	 * @return boolean - is the element is present true will be returned else false will be returned 
	 * */
	private boolean isAlreadyPresentDevice(ElectronicDevice eleDevice) {
		if(this.electronicDevices != null) {
			for(int i=0; i< this.electronicDevices.size(); i++) {
				if(this.electronicDevices.get(i).equals(eleDevice)) {
					return true;
				}
			}
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * To get concat device names and device ids
	 * @return String - device names*/
	public String getDeviceNames() {
		String returnVal = "";
		if(this.electronicDevices != null) {
			for(int i=0; i<this.electronicDevices.size(); i++) {
				returnVal += "Device ID : "+ this.electronicDevices.get(i).getDeviceId() +"\t Device Name : "+ this.electronicDevices.get(i).getDeviceName() +"\n";
			}
			return returnVal;
		}else {
			return "No device contians the resource";
		}
	}
	
	/**
	 * To get the String details of all the EResource values
	 * @return String - All details of EResource*/
	public String getDetails() {
		String returnVal = super.getDetails();
		returnVal += "DOI : "+ this.DOI +"\n"
				+ "Published Date : "+ this.publishedDate.toString() +"\n"
				+ "Device List : \n "+ getDeviceNames() +"";
		
		return returnVal;
	}

	/**
	 * To print the details of the E-Resource book*/
	public void printDetails() {
		System.out.println(getDetails());
	}
}
