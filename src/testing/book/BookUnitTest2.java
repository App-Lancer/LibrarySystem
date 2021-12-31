//$Id$
package testing.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.Book;
import main.Member;

public class BookUnitTest2 {

	/**
	 * To test update cases of Book class
	 * It creates a Book object
	 * Updates titles, damages and add authors of the Book class
	 * The updated data asserted*/
	@Test
	public void updateCase() {
		ArrayList<String> authorsList = new ArrayList<String>();
		authorsList.add("Kathy Sierra");
		
		Book newBook = new Book("Head First Java", authorsList, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		assertEquals("Head First Java", newBook.getTitle());
		assertEquals(authorsList, newBook.getAuthors());
		assertEquals("Head First Java", newBook.getDescription());
		assertEquals("0596009208", newBook.getISBN());
		assertEquals("O'Reilly Media", newBook.getPublisher());
		assertEquals(2005, newBook.getPublicationYear());	
		assertNull(newBook.getDamages());
		assertEquals("BOOK", newBook.getResourceType());
		assertEquals(true, newBook.isAvailable());
		assertNull(newBook.getUserObject());
		
		newBook.setTitle("Head First Java 2");
		assertEquals("Head First Java 2", newBook.getTitle());
		
		newBook.setDamages("Missing page 19");
		assertEquals("Missing page 19", newBook.getDamages());
		
		newBook.addAuthors("Doug Lowe");
		authorsList.add("Doug Lowe");
		assertEquals(authorsList, newBook.getAuthors());
	}
	
	/**
	 * To add a new damage to the book class
	 * asserts the value the newly added damages*/
	@Test
	public void addDamages() {
		ArrayList<String> authorsList = new ArrayList<String>();
		authorsList.add("Robert Martin");
		
		Book newBook = new Book("Clean Code", authorsList, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		assertNull(newBook.getDamages());
		newBook.setDamages("binder is damaged");
		assertEquals("binder is damaged", newBook.getDamages());
		newBook.setDamages("5th page is colored");
		assertEquals("binder is damages5th page is colored", newBook.getDamages());
	}
	
	/**
	 * To test the availability of the book
	 * To create a new book and check its availability 
	 * To add a new member object to the user object of the book class
	 * Checks the value of the availability*/
	@Test
	public void checkAvailability() {
		ArrayList<String> authorsList = new ArrayList<String>();
		authorsList.add("Rogers Cadenhead");
		
		Book newBook = new Book("Sams Teach Yourself Java in 21 Days", authorsList, "Learn java quickly", "0672337959", "Sams Publishing", 2020, null);
		assertTrue(newBook.isAvailable());
		
		Member member = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 3, "CSE", null, null);
		newBook.setUserObject(member);
		assertFalse(newBook.isAvailable());
		
		newBook.setUserObject(null);
		assertTrue(newBook.isAvailable());
	}
}
