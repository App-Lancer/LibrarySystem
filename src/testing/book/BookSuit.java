//$Id$
package testing.book;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	BookUnitTest1.class,
	BookUnitTest2.class
})

/**
 * Test suit for Book class
 * This class will contains all the unit testing for Book class*/
public class BookSuit {

}
