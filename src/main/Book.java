//$Id$
package main;

import java.util.ArrayList;

/**
 * @author Shushanna Bailey
 * This is the child class of resource class
 * The class contains the specific attributes of the book class (physical book)
 * The class contains the getters and setters method for the attributes of the book class
 * The book class represents the physical book of a library*/
public class Book extends Resource{
	
	/**
	 * ISBN value of a physical book*/
	private String isbn;
	
	/**
	 * This object contains the user object who is currently holding the user object*/
	private Member userObject;
	
	/**
	 * publisher data of the current book*/
	private String publisher;
	
	/**
	 * publisher year of the current book*/
	private int yearOfPublication;
	
	/**
	 * damages of a current book*/
	private String damages;
	
	/**
	 * Constructor class of Book class
	 * @param title - resource title
	 * @param authors - List of authors for the resource
	 * @param description - resource description
	 * @param isbn - isbn value of string book
	 * @param publisher - publisher data of book
	 * @param yearOfPublication - year of publication of the book
	 * @param damages - damages data of a book
	 * User Object value is not passed to Book constructor because creating a book object cannot be lended on creation*/
	public Book(String title, ArrayList<String> authors, String resourceDescription, String isbn, String publisher, int yearOfPublication, String damages) {
		super(title, authors, resourceDescription, "BOOK");
		this.isbn = isbn;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.damages = damages;
		this.userObject = null;
	}

	/**
	 * getter method of isbn
	 * @return String - isbn value*/
	public String getISBN() {
		return this.isbn;
	}
	
	/**
	 * setter method for isbn
	 * @param isbn - isbn value of the book*/
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * getter method for user object
	 * @return Member - user object*/
	public Member getUserObject() {
		return this.userObject;
	}
	
	/**
	 * setter method for user object
	 * @param Member - user object*/
	public void setUserObject(Member member) {
		this.userObject = member;
	}
	
	/**
	 * getter method for publisher
	 * @return String - publisher data of a book*/
	public String getPublisher() {
		return this.publisher;
	}
	
	/**
	 * setter method for publisher
	 * @param publisher - publisher data of a book*/
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * getter method for year of publication
	 * @return int - year of publication of the book*/
	public int getPublicationYear() {
		return this.yearOfPublication;
	}
	
	/**
	 * setter method for publication year
	 * @param year - publication year of the book*/
	public void setPublicationYear(int year) {
		this.yearOfPublication = year;
	}
	
	/**
	 * getter method for damages of a book
	 * @return String - damages of a book*/
	public String getDamages() {
		return this.damages;
	}
	
	/**
	 * add new damage of a book
	 * @param damage - damage of a book*/
	public void setDamages(String damage) {
		if(this.damages == null) this.damages = "";
		this.damages += damage;
	}
	
	/**
	 * To check if the book is available in the library
	 * Boolean - returns true if the book is available else false will be returned*/
	public boolean isAvailable() {
		return this.userObject == null;
	}
	
	/**
	 * To get a string of the details of the physical book
	 * If the book is available availability will be shown
	 * If the book is currently loaned then the user details holding the book will be printed
	 * @return String - print details of the book*/
	public String getDetails() {
		String returnVal = super.getDetails();
		returnVal += "ISBN : "+ this.isbn +"\n"
				+ "Publisher : "+ this.publisher +"\n"
				+ "Year of Publication : "+ this.yearOfPublication +"\n"
				+ "Damage : "+ this.damages +"\n";
				
		if(this.userObject == null) {
			returnVal += "Available : true";
		}else {
			returnVal += "Member Id : "+ this.userObject.getMemberId() +"\n"
					+ "First Name : "+ this.userObject.getFirstName() +"\n"
					+ "Last Name : "+ this.userObject.getLastName() +"\n"
					+ "Email : "+ this.userObject.getEmail() +"\n";
		}
		return returnVal;
	}
	
	/**
	 * To print the details of the book*/
	public void printDetails() {
		System.out.println(getDetails());
	}
}
