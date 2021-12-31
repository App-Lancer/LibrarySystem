//$Id$
package testing.eresource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import main.EResource;
import main.ElectronicDevice;

public class EResourceUnitTest {

	/**
	 * Basic testing for EResource class
	 * Creates a basic object and tests the getters*/
	@Test
	public void baseTest() {
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Aristides Bouras");
		
		ArrayList<ElectronicDevice> eleDevice = new ArrayList<ElectronicDevice>();
		eleDevice.add(new ElectronicDevice("System1", "System-1", "0x0", "Computer", true));
		eleDevice.add(new ElectronicDevice("System2", "System-2", "0x1", "Computer", true));
		eleDevice.add(new ElectronicDevice("Tablet1", "Tablet-1", "2x4", "Tablet", true));
		
		Date dummyDate = new Date();
		dummyDate.setYear(2009);
		
		EResource eRes = new EResource("Java and Algorithmic", authors, "Learn java programming and algo", "10.1000/182", dummyDate, eleDevice);
		
		assertEquals("Java and Algorithmic", eRes.getTitle());
		assertEquals(authors, eRes.getAuthors());
		assertEquals("Learn java programming and algo", eRes.getDescription());
		assertEquals(dummyDate, eRes.getPublishedDate());
		assertEquals("10.1000/182", eRes.getDOI());
		assertEquals(eleDevice, eRes.getElectronicDevices());
		
	}
	
	/**
	 * EResource class update operation tester
	 * To update EResource object and asserts its value*/
	@Test
	public void updateCaseTest() {
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Aristides Bouras");
		
		ElectronicDevice dev1 = new ElectronicDevice("System1", "System-1", "0x0", "Computer", true);
		ArrayList<ElectronicDevice> eleDevice = new ArrayList<ElectronicDevice>();
		eleDevice.add(dev1);
		eleDevice.add(new ElectronicDevice("System2", "System-2", "0x1", "Computer", true));
		eleDevice.add(new ElectronicDevice("Tablet1", "Tablet-1", "2x4", "Tablet", true));
		
		Date dummyDate = new Date();
		dummyDate.setYear(2009);
		
		EResource eRes = new EResource("Java and Algorithmic", authors, "Learn java programming and algo", "10.1000/182", dummyDate, eleDevice);
		
		assertEquals("Java and Algorithmic", eRes.getTitle());
		eRes.setTitle("Java and Algorithmic 2");
		assertEquals("Java and Algorithmic 2", eRes.getTitle());
		
		eRes.setDescription("Test Description");
		assertEquals("Test Description", eRes.getDescription());
	}
	
	/**
	 * To check add device to eResource and checks the message for the add device value*/
	@Test
	public void addResourceToDevice() {
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Aristides Bouras");
		
		ElectronicDevice dev1 = new ElectronicDevice("System1", "System-1", "0x0", "Computer", true);
		ArrayList<ElectronicDevice> eleDevice = new ArrayList<ElectronicDevice>();
		eleDevice.add(new ElectronicDevice("System2", "System-2", "0x1", "Computer", true));
		eleDevice.add(new ElectronicDevice("Tablet1", "Tablet-1", "2x4", "Tablet", true));
		
		Date dummyDate = new Date();
		dummyDate.setYear(2009);
		
		EResource eRes = new EResource("Java and Algorithmic", authors, "Learn java programming and algo", "10.1000/182", dummyDate, eleDevice);
		
		assertEquals("Device added successfully", eRes.addElectronicDevice(dev1));
		assertEquals("Device already contains the resource", eRes.addElectronicDevice(dev1));
	}

}
