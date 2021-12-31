//$Id$
package main;

import java.util.ArrayList;

/**
 * @author Shushanna Bailey
 * This is the base resource class
 * The class contains the basic attributes of resource class
 * The class contains the getters and setters method for the attributes of the class
 * The resource class represents the resources of a library*/
public class Resource {
	
	/**
	 * Unique resource id that can be used to identify a unique resource in the library*/
	private int resourceId;
	
	/**
	 * title of the library resource*/
	private String title;
	
	/**
	 * authors of the library resource*/
	private ArrayList<String> authors;
	
	/**
	 * resource description for the resource description*/
	private String resourceDescriptipn;
	
	/**
	 * resource type of the library resource*/
	private String resourceType;
	
	/**
	 * A static variable to hold the next id of the resource that needs to be added*/
	private static int currentId=0;
	
	/**
	 * Constructor class of Resource class
	 * @param title - resource title
	 * @param authors - List of authors for the resource
	 * @param description - resource description
	 * @param resourceType - resource type of the resource*/
	public Resource(String title, ArrayList<String> authors, String resourceDescription, String resourceType) {
		this.resourceId = currentId++;
		this.title = title;
		this.authors = authors;
		this.resourceDescriptipn = resourceDescription;
		this.resourceType = resourceType;
	}
	
	/**
	 * Getter method for resource id 
	 * @return int - resource id*/
	public int getResourceId() {
		return this.resourceId;
	}
	
	/**
	 * Getter method for title
	 * @return string - resource title*/
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * setter method for title
	 * @param title - resource title*/
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * getter method for authors
	 * @return ArrayList - resource authors*/
	public ArrayList<String> getAuthors(){
		return this.authors;
	}
	
	/**
	 * setter method for authors
	 * @param authors - resource authors*/
	public void setAuthors(ArrayList<String> authors){
		this.authors = authors;
	}
	
	/**
	 * add authors to resource authors list
	 * @param String - author string to be added to the list*/
	public void addAuthors(String author) {
		if(this.authors == null) {
			this.authors = new ArrayList<String>();
			this.authors.add(author);
		}else {
			this.authors.add(author);
		}
	}
	
	/**
	 * getter method for description
	 * @return description - resource description*/
	public String getDescription() {
		return this.resourceDescriptipn;
	}
	
	/**
	 * setter method for description
	 * @param description - resource description*/
	public void setDescription(String description) {
		this.resourceDescriptipn = description;
	}
	
	/**
	 * getter method for resource type
	 * @return String - resource type of the library resource*/
	public String getResourceType() {
		return this.resourceType;
	}
	
	/**
	 * To get a concat string of authors
	 * @return authors - String of authors list*/
	public String getStringAuthors() {
		String returnVal = "";
		for(int i=0; i<this.authors.size(); i++) {
			returnVal += this.authors.get(i) + "\n";
		}
		return returnVal;
	}
	
	/**
	 * To get the print details of all the resources
	 * @return resource details - String displaying all the strings*/
	public String getDetails() {
		String returnVal = "Resource Id : "+ this.resourceId +"\n"
				+ "Resource Title : "+ this.title +"\n"
				+ "Resource Description : "+ this.resourceDescriptipn +"\n"
				+ "Authors : "+ getStringAuthors();
		
		return returnVal;
	}
	
	/**
	 * To check if 2 resource object are equal
	 * @return boolean - true if both the ids are equal or else false is returned*/
	public Boolean isEqual(Resource resource2) {
		if(resource2 == null) return false;
		return this.resourceId == resource2.getResourceId();
	}
	
	/**
	 * To print the details of the resource
	 * Overriden in base classes*/
	public void printDetails() {
		
	}
}
