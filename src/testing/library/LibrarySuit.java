//$Id$
package testing.library;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testing.member.MemberUnitTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	MemberUnitTest.class
})

/**
 * Test suit for LibrarySuit class
 * It runs all the cases for LibrarySuit test cases*/
public class LibrarySuit {

}
