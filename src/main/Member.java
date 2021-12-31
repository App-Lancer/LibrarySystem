//$Id$
package main;

import java.util.ArrayList;

/**
 * @author Shushanna Bailey
 * This is the class of Member class
 * The class contains the specific attributes of the Member class
 * The class contains the getters and setters method for the attributes of the Member class
 * The Member class represents the members of the library*/
public class Member {
	
	/**
	 * Unique member id that can be used to identify a unique member in the library*/
	private int memberId;
	
	/**
	 * first name of the member of the the library*/
	private String firstName;

	/**
	 * last name of the member of the the library*/
	private String lastName;
	
	/**
	 * email of the member of the the library*/
	private String email;
	
	/**
	 * year of the member of the the library*/
	private int year;
	
	/**
	 * course of the member of the the library*/
	private String course;
	
	/**
	 * borrowed books of the member of the the library*/
	private ArrayList<Book> borrowedBooks;
	
	/**
	 * messages of the member of the the library*/
	private ArrayList<String> messages;
	
	/**
	 * A static variable to hold the next id of the member that needs to be added*/
	private static int nextMemberId = 0;
	
	/**
	 * Constructor class of Member class
	 * @param firstName - first name of the member
	 * @param lastName - last name of the member
	 * @param email - email of the member
	 * @param year - year of the member
	 * @param course - course of the member
	 * @param borrowedBooks - books that are holded by the member
	 * @param messages - message for the member*/
	public Member(String firstName, String lastName, String email, int year, String course, ArrayList<Book> borrowedBooks, ArrayList<String> messages) {
		this.memberId = nextMemberId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.year = year;
		this.course = course;
		this.borrowedBooks = borrowedBooks;
		this.messages = messages;
	}
	
	/**
	 * Getter method for member id
	 * @return int - member id of the library member*/
	public int getMemberId() {
		return this.memberId;
	}
	
	/**
	 * Getter method for first name
	 * @return String - first name of the library member*/
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * setter method for first name
	 * @param firstName - first name of the library member*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter method for last name
	 * @return String - last name of the library member*/
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * setter method for last name
	 * @param lastName - last name of the library member*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter method for email
	 * @return String - email of the library member*/
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * setter method for email
	 * @param email - email of the library member*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter method for year
	 * @return int - year of the library member*/
	public int getYear() {
		return this.year;
	}
	
	/**
	 * setter method for year
	 * @param year - year of the library member*/
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Getter method for course
	 * @return String - course of the library member*/
	public String getCourse() {
		return this.course;
	}
	
	/**
	 * setter method for course
	 * @param course - course of the library member*/
	public void setCourse(String course) {
		this.course = course;
	}
	
	/**
	 * Getter method for borrowed books
	 * @return ArrayList<Book> - borrowed books for the library member*/
	public ArrayList<Book> getBorrowedBooks(){
		return this.borrowedBooks;
	}
	
	/**
	 * Setter method for borrowed books
	 * @param ArrayList<Book> - borrowed books for the library member*/
	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	/**
	 * Add a new book to the borrowed books list of the member
	 * if the book is not available error message will be shown
	 * If the book is available the book will be added to the list
	 * @param Book - A new book resource 
	 * @return String - message after adding the resource
	 * */
	public String addBorrowedBook(Book resource) {
		
		if(resource == null) {
			return "Null value cannot be added";
		}
		
		if(this.borrowedBooks == null) {
			this.borrowedBooks = new ArrayList<Book>();
			if(resource.isAvailable()) {
				this.borrowedBooks.add(resource);
				return "Book borrowed successfully";
			}else {
				return "The book is not available";
			}
		}else {
			if(!isAlreradyBorrowed(resource) && resource.isAvailable()) {
				this.borrowedBooks.add(resource);
				return "Book borrowed successfully";
			}else {
				return "The books is not available";
			}
		}
	}
	
	public void removeBorrowedBook(Book resource) {
		
		if(resource == null) {
			System.out.println("Null value cannot be added");
		}
		
		if(this.borrowedBooks == null) {
			System.out.println("Currently the book is not borrowed");
		}else {
			for(int i=0; i<this.borrowedBooks.size(); i++) {
				if(this.borrowedBooks.get(i).equals(resource)) {
					this.borrowedBooks.remove(i);
					System.out.println("Book removed from borrowed list");
					return;
				}
			}
			System.out.println("Currently the book is not borrowed");
		}
	}
	
	/**
	 * To check if the book object is already present in the borrowed list object
	 * If the object is not present true will be returned else false will be returned
	 * @return boolean - indicating if the book is already present in the borrowed book list*/
	private boolean isAlreradyBorrowed(Book resource) {
		if(this.borrowedBooks != null) {
			for(int i=0;i<this.borrowedBooks.size();i++) {
				if(this.borrowedBooks.get(i).equals(resource)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Getter method for messages
	 * @return ArrayList<String> - messages of the library member*/
	public ArrayList<String> getMessages(){
		return this.messages;
	}
	
	/**
	 * Setter method for messages
	 * @param ArrayList<String> - messages of the library member*/
	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}
	
	/**
	 * To add a new message into the message list of the borrowed user
	 * @param message - new message to be added*/
	public void addMessage(String message) {
		if(this.messages != null) {
			this.messages.add(message);
		}else {
			this.messages = new ArrayList<String>();
			this.messages.add(message);
		}
	}
	
	/**
	 * To get the size of the borrowed books
	 * @return int - size of the borrowed books*/
	public int noOfBorrowedBooks() {
		return this.borrowedBooks.size();
	}
	
	/**
	 * To concat the messages for the library user
	 * @return String - String values of messages for the library member*/
	public String getMessagAsString() {
		String returnVal = "";
		if(this.messages != null && this.messages.size() > 0) {
			for(int i=0; i<this.messages.size(); i++) {
				returnVal += this.messages.get(i) + "\n";
			}
			return returnVal;
		}
		return "No messages";
	}
	
	/**
	 * To print all the messages of the library member*/
	public void printAllMessages() {
		System.out.println("Messages : ");
		System.out.println(getMessagAsString());
	}
	
	/**
	 * To print all the borrowed books of the library member*/
	public void printBorrowedBooks() {
		System.out.println("Borrowed books : ");
		if(this.borrowedBooks != null) {
			for(int i=0; i<this.borrowedBooks.size(); i++) {
				System.out.println(this.borrowedBooks.get(i).getDetails());
			}
		}else {
			System.out.println("No books borrowed");
		}
	}
	
	/**
	 * To get concat of the basic details of the library member
	 * @return String - basic details string*/
	public String getBasicDetails() {
		String returnVal = "Member Id : "+ this.memberId +"\n"
				+ "First Name : "+ this.firstName +"\n"
				+ "Last Name : "+ this.lastName +"\n"
				+ "Email : "+ this.email +"\n"
				+ "Year : "+ this.year +"\n"
				+ "Course : "+ this.course +"\n";
		return returnVal;
	}
	
	/**
	 * To print all the details of the member*/
	public void printDetails() {
		System.out.println(getBasicDetails());
		printAllMessages();
		printBorrowedBooks();
	}
}
