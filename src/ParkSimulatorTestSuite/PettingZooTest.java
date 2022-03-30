package ParkSimulatorTestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkSimulator.*;

class PettingZooTest {
	
	private DefinePettingZoo pettingZoo;
	
	@BeforeEach
	void setup() {
		pettingZoo = new DefinePettingZoo("my zoo"); 
	}

	@Test
	void listOptionsTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.listOptions();
	    String expectedOutput  = "Input \"pet bunny\" to pet the bunny."
				+ "\nInput \"leave petting zoo\" to return to the park entrance.";
	    
	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void petBunnyTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.petBunny();
	    String expectedOutput  = "You are petting a bunny! The bunny's name is Fluffy. She seems happy :)";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void sendUserToLocationTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.sendUserToLocation("invalid");
	    String expectedOutput  = "Invalid input. What would you like to do?";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}

	
	@Test 
	void promptTest() {  
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.prompt();
	    
	    String expectedOutput  = "Welcome to the petting zoo! What would you like to do? (Input \"options\" to see what you can do)";
	    assertEquals(expectedOutput, outContent.toString().trim());
	}

	

}
