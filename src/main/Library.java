//$Id$
package main;

import java.util.ArrayList;

/**
 * @author Shushanna Bailey
 * This is the class of Library class
 * The class contains the specific attributes of the Library class
 * The class contains methods for Library class
 * The class contains the getters and setters method for the attributes of the Library class
 * The Library class represents the the library*/
public class Library {
	
	/**
	 * Name of the library name*/
	private String libraryName;
	
	/**
	 * List of library registered library member*/
	private ArrayList<Member> libraryMembers;
	
	/**
	 * List of registered resources in the library*/
	private ArrayList<Resource> libraryCategory;

	/**
	 * List of registered electronic device in the library*/
	private ArrayList<ElectronicDevice> electronicDevice;
	
	/**
	 * Constructor of Library class
	 * @param name - library name
	 * @param libraryMembers - registered members in the library
	 * @param libraryCategory - library category of books
	 * @param electronicDevice - List of electronic device registered to library*/
	public Library(String name, ArrayList<Member> libraryMembers, ArrayList<Resource> libraryCategory, ArrayList<ElectronicDevice> electronicDevice) {
		this.libraryName = name;
		this.libraryMembers = libraryMembers;
		this.libraryCategory = libraryCategory;
		this.electronicDevice = electronicDevice;
	}
	
	/**
	 * Getter method for library name
	 * @return String - library name*/
	public String getLibraryName() {
		return this.libraryName;
	}
	
	/**
	 * setter method for library name
	 * @param libraryName - library name*/
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	/**
	 * Getter method of library members
	 * @returnArrayList<Member> - list of library members*/
	public ArrayList<Member> getLibraryMembers(){
		return this.libraryMembers;
	}
	
	/**
	 * setter method for library members
	 * @param ArrayList<Member> - list of library members*/
	public void setLibraryMembers(ArrayList<Member> libraryMembers) {
		this.libraryMembers = libraryMembers;
	}
	
	/**
	 * Getter method for library category
	 * @return ArrayList<Resource> - list of resources in library*/
	public ArrayList<Resource> getLibraryCategory(){
		return this.libraryCategory;
	}
	
	/**
	 * setter method for library category
	 * @param ArrayList<Resource> - list of resources in library*/
	public void setLibraryCategory(ArrayList<Resource> libraryCategory) {
		this.libraryCategory = libraryCategory;
	}
	
	/**
	 * Getter method for electronic devices
	 * @return ArrayList<ElectronicDevice> - list of devices registered in library*/
	public ArrayList<ElectronicDevice> getElectronicDevice(){
		return this.electronicDevice;
	}
	
	/**
	 * Setter method for electronic devices
	 * @param ArrayList<ElectronicDevice> - list of devices registered in library*/
	public void setElectronicDevice(ArrayList<ElectronicDevice> electronicDevice) {
		this.electronicDevice = electronicDevice;
	}
	
	/**
	 * To print all the details of the library
	 * It prints the details of the members, resources and devices*/
	public void printDetails() {
		System.out.println("Library Details :");
		System.out.println("Library Name :" + this.libraryName);
		printAllMembers();
		printAllResources();
		printElectronicDevices();
	}
	
	/**
	 * To print the details of the members*/
	private void printAllMembers() {
		System.out.println("Library Members :");
		if(this.libraryMembers != null) {
			for(int i=0; i<this.libraryMembers.size(); i++) {
				this.libraryMembers.get(i).printDetails();
			}
		}else {
			System.out.println("No members registered to the library");
		}
	}
	
	/**
	 * To print the details of the resources*/
	private void printAllResources() {
		System.out.println("Available Resources : ");
		if(this.libraryCategory != null) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				this.libraryCategory.get(i).printDetails();
			}
		}else {
			System.out.println("No resources are currenlty available");
		}
	}
	
	/**
	 * To print the details of the devices*/
	private void printElectronicDevices() {
		System.out.println("Library electronic devies : ");
		if(this.electronicDevice != null) {
			for(int i=0; i<this.electronicDevice.size(); i++) {
				this.electronicDevice.get(i).printDetails();
			}
		}else {
			System.out.println("No devices registered in the library");
		}
	}
	
	/**
	 * To check if the resource is present in the library catalogue
	 * @param resource - resource object to check in catalogue of the library
	 * @return boolean - indicating the object present in the library*/
	public boolean checkResourceInCatelog(Resource resource) {
		
		if(resource == null) {
			return false;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				if(this.libraryCategory.get(i).equals(resource)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * To search for a resource and return the library resource object
	 * @param resource - resource object to be searched
	 * @return resource - resource object to be returned from the catalogue*/
	public Resource searchResourceObject(Resource resource) {
		
		if(resource == null) {
			return null;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				if(this.libraryCategory.get(i).equals(resource)) {
					return this.libraryCategory.get(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * To update the title of the resource object
	 * The resource object from the catalogue is retrieved
	 * The title object is updated in the resource object
	 * @param resource - resource value
	 * @param title - title value of the resource*/
	public void updateResourceTitle(Resource resource, String title) {
		
		if(resource == null || title == null) {
			System.out.println("Null values cannot be passed");
			return;
		}
		
		Resource catelogRes = searchResourceObject(resource);
		if(catelogRes != null) {
			catelogRes.setTitle(title);
		}else {
			System.out.println("The resource is not present in the library category");
		}
	}
	
	/**
	 * To search for the catalogue values for the given ISBN
	 * Only the resource - book values will be checked
	 * If the ISBN value will be printed 
	 * At the end the total number of resources matching the ISBN will be printed
	 * @param isbn - isbn values of book*/
	public void searchByISBN(String isbn) {
		
		if(isbn == null) {
			System.out.println("Null value cannot be passed");
			return;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			int totalResource = 0;
			for(int i=0; i<this.libraryCategory.size(); i++) {
				Resource res = this.libraryCategory.get(i);
				if("BOOK".equals(res.getResourceType())) {
					if(((Book)res).getISBN().equals(isbn)) {
						res.printDetails();
						totalResource++;
					}
				}
			}
			System.out.println("Total ISBN resource : " + totalResource);
		}
	}
	
	/**
	 * To search for the catalogue values for the given author name
	 * If the author matches the resource details will be printed 
	 * At the end the total number of resources matching the author will be printed
	 * @param author - author values of string*/
	public void searchByAuthor(String author) {
		
		if(author == null) {
			System.out.println("Null value cannot be passed");
			return;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			int totalResource = 0;
			for(int i=0; i<this.libraryCategory.size(); i++) {
				Resource res = this.libraryCategory.get(i);
				if(isAuthorPresent(res, author)) {
					res.printDetails();
					totalResource++;
				}
			}
			System.out.println("Total author resource : "+ totalResource);
		}
	}
	
	/**
	 * To check if the author is a author for the resource
	 * @param resource - resource object
	 * @param author - author value 
	 * @return boolean - indicating if the author is a author of the resource*/
	private boolean isAuthorPresent(Resource res, String author) {
		ArrayList<String> authors = res.getAuthors();
		if(!authors.isEmpty()) {
			for(int i=0; i<authors.size(); i++) {
				if(author.equals(authors.get(i))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * To remove a resource from the library catalogue
	 * The library catalogue is looped through and if it matches the passed object the resource is removed from the catalogue
	 * if the resource is not present a message will be printed
	 * @param resource - resource object to be passed*/
	public void removeResource(Resource resource) {
		
		if(resource == null) {
			System.out.println("Null value cannot be passed");
			return;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				if(this.libraryCategory.get(i).equals(resource)) {
					this.libraryCategory.remove(i);
					System.out.println("The resource is removed from the library");
					return;
				}
			}
		}
		System.out.println("The resource is not present in the catelog");
	}
	
	/**
	 * To remove a resource from the library catalogue
	 * If the position not present in the catalogue error message will be printed
	 * @param int - position of the resource to be removed*/
	public void removeResource(int position) {
		if(position > 0 && position < this.libraryCategory.size()) {
			this.libraryCategory.remove(position);
			System.out.println("The resource is removed from the library");
			return;
		}
		System.out.println("No resource is present in the index : "+ position);
	}
	
	/**
	 * To print all the books that are available in the library catalogue*/
	public void printAvailableBooks() {
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				Resource res = this.libraryCategory.get(i);
				if("BOOK".equals(res.getResourceType())) {
					if(((Book)res).isAvailable()) {
						res.printDetails();
					}
				}
			}
		}
		System.out.println("No books are available");
	}
	
	/**
	 * To return the number of resources in the library catalogue*/
	public int noOfResources() {
		return this.libraryCategory.size();
	}
	
	/**
	 * To add a new resource into the library catalogue
	 * if the resource is already present in the catalogue error message will be shown
	 * @param newRes - new resource to be added in the catalogue
	 * */
	public void addResource(Resource newRes) {
		
		if(newRes == null) {
			System.out.println("Null value cannot be passed");
			return;
		}
		
		if(this.libraryCategory.isEmpty()) {
			this.libraryCategory = new ArrayList<Resource>();
			this.libraryCategory.add(newRes);
		}else {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				if(this.libraryCategory.get(i).equals(newRes)) {
					System.out.println("The resource is already present in catalog");
					return;
				}
			}
			this.libraryCategory.add(newRes);
		}
	}
	
	/**
	 * To loan a new book to a user
	 * If the book is not available then error message will be shown
	 * resource book user object will be set with the member value
	 * The resource book is added to borrowed list of the user
	 * @param resource - resource object to be loaned
	 * @param member- - A member to be loaned to the resource
	 * */
	public void loanBook(Resource resource, Member member) {
		
		if(resource == null || member == null) {
			System.out.println("Null value cannot be passed");
			return;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			if(checkResourceInCatelog(resource)) {
				if("BOOK".equals(resource.getResourceType())) {
					if(((Book)resource).isAvailable()) {
						Book catBook = (Book)searchResourceObject(resource);
						if(checkRegisteredUser(member)) {
							Member user = getUserObject(member);
							if(user.getBorrowedBooks().size() <5) {
								catBook.setUserObject(user);
								System.out.println(user.addBorrowedBook(catBook));
							}else {
								System.out.println("The current user as 5 borrowed books");
							}
						}
					}else {
						System.out.println("The book is not currentlty available");
					}
				}
			}else{
				System.out.println("The book is not present in the catalog");
			}
		}else {
			System.out.println("The book is not present in the catalog");
		}
	}
	
	/**
	 * To check if the passed user object is registered user object for the library
	 * @param user - user object to check if he is registered in the library
	 * @return boolean - indicating the user registered to the library*/
	private boolean checkRegisteredUser(Member user) {
		if(!this.libraryMembers.isEmpty()) {
			for(int i=0; i<this.libraryMembers.size(); i++) {
				if(this.libraryMembers.get(i).equals(user)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * To get the matching user object of the library member
	 * @param user - user object to be matched for
	 * @return Member - user object that matches the passed in object*/
	private Member getUserObject(Member user) {
		if(!this.libraryMembers.isEmpty()) {
			for(int i=0; i<this.libraryMembers.size();i++) {
				if(this.libraryMembers.get(i).equals(user)) {
					return this.libraryMembers.get(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * To return a books back to the library
	 * If the book is not in loaned error message will be printed
	 * If the book is not present in the catalogue error message will be shown to the user
	 * The returned books userObject is updated to null
	 * The book is removed from the user objects borrowed books list
	 * @param resource - resource to be returned
	 * @param addDamage - boolean value to add the damage or to skip the damage value
	 * @param damages - damages value of the string
	 * @return Resource - resource that is returned and the updated object*/
	public Resource returnLoandedBook(Resource resource, boolean addDamage, String damages) {
		
		if(resource == null || damages == null) {
			System.out.println("Null value cannot be passed");
			return null;
		}
		
		if(!this.libraryCategory.isEmpty()) {
			if(checkResourceInCatelog(resource)) {
				if("BOOK".equals(resource.getResourceType())) {
					if(!((Book)resource).isAvailable()) {
						Book catBook = (Book)searchResourceObject(resource);
						catBook.getUserObject().removeBorrowedBook(catBook);
						catBook.setUserObject(null);
						if(addDamage) {
							catBook.setDamages(damages);
						}
						System.out.println("The book is returned successfully");
						return catBook;
					}else {
						System.out.println("The book is not currentlty loaned");
					}
				}
			}else {
				System.out.println("The book is not present in the catalog");
			}
		}else {
			System.out.println("The book is not present in the catalog");
		}
		return null;
	}
	
	/**
	 * To publish a message to all the users who are currently holding books
	 * @param message - message to be published*/
	public void publishMessages(String message) {
		if(!this.libraryMembers.isEmpty()) {
			for(int i=0;i<this.libraryMembers.size(); i++) {
				if(this.libraryMembers.get(i).getBorrowedBooks().size() > 0) {
					this.libraryMembers.get(i).addMessage(message);
				}
			}
		}else {
			System.out.println("No members are registered with the library");
		}
	}
	
	/**
	 * To print all the book details that are in library catalogue*/
	public void printBookDetails() {
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				Resource res = this.libraryCategory.get(i);
				if("BOOK".equals(res.getResourceType())) {
					res = (Book)res;
					res.printDetails();
				}
			}
		}else {
			System.out.println("No resources in library");
		}
	}
	
	/**
	 * To print all the e-resource details that are in the library catalogue*/
	public void printElectronicDeviceDetails() {
		if(!this.libraryCategory.isEmpty()) {
			for(int i=0; i<this.libraryCategory.size(); i++) {
				Resource res = this.libraryCategory.get(i);
				if("ERESOURCE".equals(res.getResourceType())) {
					res = (EResource)res;
					res.printDetails();
				}
			}
		}else {
			System.out.println("No resources in library");
		}
	}
}
