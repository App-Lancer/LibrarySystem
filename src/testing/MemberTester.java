//$Id$
package testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testing.member.MemberSuit;

/**
 * MemberTester runner
 * The class runs the test cases of the MemberTester class */
public class MemberTester {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(MemberSuit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	
		System.out.println(result.wasSuccessful());
	}
}
