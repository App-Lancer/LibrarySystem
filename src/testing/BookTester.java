//$Id$
package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testing.book.BookSuit;

/**
 * To run the book test suit Book class
 * */
public class BookTester {

	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(BookSuit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
