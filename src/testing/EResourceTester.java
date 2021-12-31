//$Id$
package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testing.eresource.EResourceSuit;

/**
 * Test suit runner for EResource class*/
public class EResourceTester {

	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(EResourceSuit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	
		System.out.println(result.wasSuccessful());
	}
}
