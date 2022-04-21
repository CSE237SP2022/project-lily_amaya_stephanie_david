package ParkSimulatorTestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import parkSimulator.Location;
import parkSimulator.Park;

import org.junit.jupiter.api.Test;

import parkSimulator.Park;

class ParkTest {

	@Test
	void ParkNameTest() {
		Park myPark = new Park("Cool Park");
		String TestParkName = myPark.getParkName();
		assertTrue(TestParkName.equals("Cool Park"));
	}

	
	@Test 
	void LocationCountZero() {
		Park myPark = new Park("Cool Park");
		assertTrue(myPark.getLocationCount()==0);
	}
	
	@Test 
	void addLocationMultiple() {
		Park myPark = new Park("Cool Park");
		Location RockWall = new Location("RockWall");
		Location Pool = new Location("Pool");
		myPark.addLocation(RockWall);
		myPark.addLocation(Pool);
		
		assertTrue(myPark.getLocationCount()==2);
	}
	
	@Test
	void printLocationTest() {
		Park myPark = new Park("Cool Park");
		Location RockWall = new Location("RockWall");
		Location Pool = new Location("Pool");
		myPark.addLocation(RockWall);
		myPark.addLocation(Pool);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    myPark.printLocations();
	    String expectedOutput  = "RockWall\nPool";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	
	@Test
	void getUserLocationTest() {
		Park myPark = new Park("Cool Park");
		Location RockWall = new Location("RockWall");
		Location Pool = new Location("Pool");
		myPark.addLocation(RockWall);
		myPark.addLocation(Pool);
		
		

	    String output = myPark.getUserLocation("rockwall");
	    String expectedOutput  = "Invalid location. Please enter a valid location.";

	    assertEquals(expectedOutput, output );
	}
}
