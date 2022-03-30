package ParkSimulatorTestSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import parkSimulator.Location;
import parkSimulator.Park;

@RunWith(Suite.class)
@SuiteClasses({ GardenTestSuite.class })
public class LocationTest {

	@Test
	void getLocationNameTest() {
		
		Location RockWall = new Location("RockWall");


	    String output = RockWall.getLocationName();
	    String expectedOutput  = "RockWall";

	    assertEquals(expectedOutput, output );
	}
	
}
