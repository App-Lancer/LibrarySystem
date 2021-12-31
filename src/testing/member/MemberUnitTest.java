//$Id$
package testing.member;

import static org.junit.jupiter.api.Assertions.*; 

import java.util.ArrayList;

import org.junit.Test;

import main.Book;
import main.Member;

public class MemberUnitTest {

	/**
	 * Basic test case for Member class
	 * A object is created for member class and the getter methods are tested*/
	@Test
	public void baseCase() {
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		
		Book book1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Book book2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Book book3 = new Book("Clean Code", authors3, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("Welcome");
		messages.add("Time to return book");
		messages.add("Renue your card");
		
		Member member = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", books, messages);
		assertEquals("Hugh", member.getFirstName());
		assertEquals("Brissett", member.getLastName());
		assertEquals("Hugh.Brissett@test.com", member.getEmail());
		assertEquals(3, member.getYear());
		assertEquals("CSE", member.getCourse());
		assertEquals(books, member.getBorrowedBooks());
		assertEquals(messages, member.getMessages());
		assertEquals(3, member.noOfBorrowedBooks());
	}
	
	/**
	 * Update case check for Member class
	 * The values are updated and the updated values are asserted*/
	@Test
	public void updateCase() {
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		
		Book book1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("Welcome");
		messages.add("Time to return book");
		messages.add("Renue your card");
		
		Member member = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", books, messages);
		assertEquals("Hugh", member.getFirstName());
		member.setFirstName("Hugh2");
		assertEquals("Hugh2", member.getFirstName());
		
		assertEquals("Brissett", member.getLastName());
		member.setLastName("Brissett2");
		assertEquals("Brissett2", member.getLastName());
		
		assertEquals("Hugh.Brissett@test.com", member.getEmail());
		member.setEmail("Hugh.Brissett+2@test.com");
		assertEquals("Hugh.Brissett+2@test.com", member.getEmail());
		
		assertEquals(3, member.getYear());
		member.setYear(4);
		assertEquals(4, member.getYear());

		assertEquals(1, member.noOfBorrowedBooks());
	}
	
	/**
	 * To test add borrow book test case
	 * Checks all the case for add borrow cases*/
	@Test
	public void addBorrowBook() {
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		
		Book book1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Book book2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Book book3 = new Book("Clean Code", authors3, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("Welcome");
		messages.add("Time to return book");
		messages.add("Renue your card");
		
		Member member = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", books, messages);
		assertEquals("Hugh", member.getFirstName());
		assertEquals("Brissett", member.getLastName());
		assertEquals(1, member.noOfBorrowedBooks());
		
		assertEquals("Null value cannot be added", member.addBorrowedBook(null));
		assertEquals("Book borrowed successfully", member.addBorrowedBook(book2));
		
		book3.setUserObject(member);
		assertEquals("The books is not available", member.addBorrowedBook(book3));
		assertEquals(2, member.noOfBorrowedBooks());
	}
	
	/**
	 * To add a new message for the user*/
	@Test
	public void addMessage() {
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		Book book1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book1);
		
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("Welcome");
		messages.add("Time to return book");
		messages.add("Renue your card");
		
		Member member = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", books, messages);
		assertEquals("Hugh", member.getFirstName());
		assertEquals("Brissett", member.getLastName());
		assertEquals(1, member.noOfBorrowedBooks());
		
		member.addMessage("Test Message");
		messages.add("Test Message");
		
		assertEquals(messages, member.getMessages());
	}
}
