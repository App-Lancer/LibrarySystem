//$Id$
package testing.electronicdevice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import main.ElectronicDevice;

public class ElectronicDeviceUnitTester {

	/**
	 * Basic test case for ElectronicDevice
	 * A object is created and the getter methods are tested*/
	@Test
	public void basicTest() {
		ElectronicDevice testDevice = new ElectronicDevice("Computer1", "Computer-1", "1x1", "Computer", true);
		assertEquals("Computer1", testDevice.getDeviceName());
		assertEquals("Computer-1", testDevice.getDeviceDescription());
		assertEquals("1x1", testDevice.getLocation());
		assertEquals("Computer", testDevice.getDeviceType());
		assertTrue(testDevice.getAvailability());
	}
	
	/**
	 * Update case for ElectronicDevice
	 * A object is created and update values of the object and the updated values are asserted*/
	@Test
	public void updateCase() {
		ElectronicDevice testDevice = new ElectronicDevice("Tablet1", "Tablet-1", "12x11", "Tablet", true);
		assertEquals("Tablet1", testDevice.getDeviceName());
		testDevice.setDeviceName("Tablet2");
		assertEquals("Tablet2", testDevice.getDeviceName());
		
		assertEquals("Tablet-1", testDevice.getDeviceDescription());
		testDevice.setDeviceDescription("Tablet-2");
		assertEquals("Tablet-2", testDevice.getDeviceDescription());
		
		assertEquals("12x11", testDevice.getLocation());
		testDevice.setLocation("9X11");
		assertEquals("9X11", testDevice.getLocation());
		
		testDevice.toggleAvailability();
		assertFalse(testDevice.getAvailability());
	}

}
