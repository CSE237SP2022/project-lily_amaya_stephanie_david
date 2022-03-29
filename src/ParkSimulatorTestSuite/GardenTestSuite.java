package ParkSimulatorTestSuite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import java.util.Scanner;
import parkSimulator.DefineGarden;



public class GardenTestSuite {

	
	@Test
	public void printflowerHashMap() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	      
	   DefineGarden garden = new DefineGarden("Test Garden");
	    garden.printFlowerHashMap();
	     
	     String expectedOutput  = "{Dandalions=6, Marigolds=3, Roses=4, Begonias=8, Sunflowers=10}\n"; 

	     assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test 
	public void promptOutput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	      
	    DefineGarden garden = new DefineGarden("Test Garden");
	    garden.promptGarden();
	     
	    String expectedOutput  = "You can plant and pick flowers, and you can use status to check the status of your garden\nWhat would you like to do?\n"; 

	    assertEquals(expectedOutput, outContent.toString());
		
	}
	
//	@Test 
//	public void promptVariableCapture() {
//	      
//		DefineGarden garden = new DefineGarden("Test Garden");
//	    garden.promptGarden();
//	    
//	    Scanner gardenUserInput = new Scanner(System.in);
//	    String promptInput = gardenUserInput.nextLine();
//	   
//	   assertTrue(promptInput.equals(gardenUserInput.toString());
//
//	}
	
	
	
	
	
	
	
}
