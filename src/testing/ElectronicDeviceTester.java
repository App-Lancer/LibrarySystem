//$Id$
package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testing.book.BookSuit;

/**
 * Electronic device test runner
 * The class runs the test cases of the Electronic Device class */
public class ElectronicDeviceTester {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(BookSuit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
