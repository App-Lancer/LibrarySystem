//$Id$
package testing.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

import main.Book;

public class BookUnitTest1 {

	/**
	 * Basic Book class Test
	 * It creates a new object of Book class
	 * It tests all the getter methods for the class and checks its values of the getter*/
	@Test
	public void basicBookTest() {
		ArrayList<String> authorsList = new ArrayList<String>();
		authorsList.add("Timothy Needham");
		
		Book newBook = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authorsList, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		assertEquals("Learn Java: A Crash Course Guide to Learn Java in 1 Week", newBook.getTitle());
		assertEquals(authorsList, newBook.getAuthors());
		assertEquals("To learn java programming", newBook.getDescription());
		assertEquals("1726643026", newBook.getISBN());
		assertEquals("Independently published", newBook.getPublisher());
		assertEquals(2018, newBook.getPublicationYear());	
		assertEquals("No Damage", newBook.getDamages());
		assertEquals("BOOK", newBook.getResourceType());
		assertEquals(true, newBook.isAvailable());
		assertNull(newBook.getUserObject());
	}
}
