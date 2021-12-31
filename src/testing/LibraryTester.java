//$Id$
package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testing.library.LibrarySuit;

/**
 * LibraryTester class test runner
 * The class runs the test cases of the LibraryTester class */
public class LibraryTester {

	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(LibrarySuit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
