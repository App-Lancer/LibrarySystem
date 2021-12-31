//$Id$
package testing.library;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import main.Book;
import main.EResource;
import main.ElectronicDevice;
import main.Library;
import main.Member;
import main.Resource;

public class LibraryUnitTest {

	/**
	 * To test the basic cases of the Library class
	 * To check all the getter methods of the library class*/
	@Test
	public void basicCase() {
		
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		ArrayList<String> authors4 = new ArrayList<String>();
		authors4.add("Rogers Cadenhead");
		
		ArrayList<String> author5 = new ArrayList<String>();
		author5.add("Aristides Bouras");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date1 = new Date();
		date1.setYear(2009);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res3 = new Book("Clean Code", authors3, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		Resource res4 = new Book("Sams Teach Yourself Java in 21 Days", authors4, "Learn java quickly", "0672337959", "Sams Publishing", 2020, null);
		Resource res5 = new EResource("Java and Algorithmic", author5, "Learn java programming and algo", "10.1000/182", date1, resDevice1);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		resource.add(res3);
		resource.add(res4);
		resource.add(res5);
		resource.add(res6);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		Member member3 = new Member("Leontre", "Roberts", "Leontre.Roberts@test.com", 4, "CSE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		members.add(member3);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		
		assertEquals("Library1", lib.getLibraryName());
		assertEquals(members, lib.getLibraryMembers());
		assertEquals(resource, lib.getLibraryCategory());
		assertEquals(devices, lib.getElectronicDevice());
	}
	
	/** 
	 * Test case to check if the resource is present in the catalogue
	 * All cases to check if the resource is present in the catalogue*/
	@Test
	public void testResourceInCatelog() {
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		assertTrue(lib.checkResourceInCatelog(res1));
		
		assertFalse(lib.checkResourceInCatelog(res6));
	}

	/**
	 * To search a resource in the catalogue
	 * test case to search a resource in the catalogue*/
	@Test
	public void testSearchResource() {
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		assertEquals(res1, lib.searchResourceObject(res1));
		assertNull(lib.searchResourceObject(res6));
	}
	
	/**
	 * Test case to update the title of the resource*/
	@Test
	public void testTitleUpdate() {
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		resource.add(res6);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		lib.updateResourceTitle(res1, "TestTitle");
		lib.searchByISBN("0596009208");
		lib.searchByAuthor("Timothy Needham");
		
		assertEquals(3, lib.noOfResources());
		lib.removeResource(res1);
		assertEquals(2, lib.noOfResources());
		lib.removeResource(1);
		assertEquals(1, lib.noOfResources());
	}
	
	/**
	 * To test adding resource into the catalogue*/
	@Test
	public void addResource() {
		
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		ArrayList<String> authors4 = new ArrayList<String>();
		authors4.add("Rogers Cadenhead");
		
		ArrayList<String> author5 = new ArrayList<String>();
		author5.add("Aristides Bouras");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date1 = new Date();
		date1.setYear(2009);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res3 = new Book("Clean Code", authors3, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		Resource res4 = new Book("Sams Teach Yourself Java in 21 Days", authors4, "Learn java quickly", "0672337959", "Sams Publishing", 2020, null);
		Resource res5 = new EResource("Java and Algorithmic", author5, "Learn java programming and algo", "10.1000/182", date1, resDevice1);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		resource.add(res6);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		Member member3 = new Member("Leontre", "Roberts", "Leontre.Roberts@test.com", 4, "CSE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		members.add(member3);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		
		lib.addResource(null);
		lib.addResource(res1);
		lib.addResource(res4);
	}
	
	/**
	 * Test case to stimulate the loan book*/
	@Test
	public void testLoanBook() {
		ElectronicDevice device1 = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		ElectronicDevice device2 = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		ElectronicDevice device3 = new ElectronicDevice("Computer2", "Computer-2", "9x11", "Computer", true);
		
		ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
		devices.add(device1);
		devices.add(device2);
		devices.add(device3);
		
		ArrayList<String> authors1 = new ArrayList<String>();
		authors1.add("Timothy Needham");
		
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Kathy Sierra");
		
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Robert Martin");
		
		ArrayList<String> authors4 = new ArrayList<String>();
		authors4.add("Rogers Cadenhead");
		
		ArrayList<String> author5 = new ArrayList<String>();
		author5.add("Aristides Bouras");
		
		ArrayList<String> author6 = new ArrayList<String>();
		author6.add("Aristides Bouras");
		
		
		ArrayList<ElectronicDevice> resDevice1 = new ArrayList<ElectronicDevice>();
		resDevice1.add(device1);
		resDevice1.add(device2);
		
		ArrayList<ElectronicDevice> resDevice2 = new ArrayList<ElectronicDevice>();
		resDevice2.add(device2);
		
		Date date1 = new Date();
		date1.setYear(2009);
		
		Date date2 = new Date();
		date2.setYear(2004);
		
		Resource res1 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", authors1, "To learn java programming", "1726643026", "Independently published", 2018, "No Damage");
		Resource res2 = new Book("Head First Java", authors2, "Head First Java", "0596009208", "O'Reilly Media", 2005, null);
		Resource res3 = new Book("Clean Code", authors3, "How to write clean code", "9780132350", "Prentice Hall", 2008, null);
		Resource res4 = new Book("Sams Teach Yourself Java in 21 Days", authors4, "Learn java quickly", "0672337959", "Sams Publishing", 2020, null);
		Resource res5 = new EResource("Java and Algorithmic", author5, "Learn java programming and algo", "10.1000/182", date1, resDevice1);
		Resource res6 = new EResource("Java and Algorithmic", author6, "Learn java programming and algo", "10.1000/182", date2, resDevice2);
		
		ArrayList<Resource> resource = new ArrayList<Resource>();
		resource.add(res1);
		resource.add(res2);
		resource.add(res3);
		resource.add(res6);
		
		Member member1 = new Member("Hugh", "Brissett", "Hugh.Brissett@test.com", 3, "CSE", null, null);
		Member member2 = new Member("Chad", "Johnson", "Chad.Johnson@test.com", 2, "ECE", null, null);
		Member member3 = new Member("Leontre", "Roberts", "Leontre.Roberts@test.com", 4, "CSE", null, null);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(member1);
		members.add(member2);
		members.add(member3);
		
		
		Library lib = new Library("Library1", members, resource, devices);
		lib.loanBook(res1, member1);
		lib.loanBook(res1, member2);
		lib.loanBook(res4, member1);
	}
}
