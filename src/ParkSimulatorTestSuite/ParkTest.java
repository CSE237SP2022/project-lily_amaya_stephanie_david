package ParkSimulatorTestSuite;

import static org.junit.jupiter.api.Assertions.*;
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
		Location Pool = new Location("RockWall");
		myPark.addLocation(RockWall);
		myPark.addLocation(Pool);
		
		assertTrue(myPark.getLocationCount()==2);
	}
	
}
