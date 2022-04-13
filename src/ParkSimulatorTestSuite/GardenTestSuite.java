package ParkSimulatorTestSuite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import parkSimulator.DefineGarden;



public class GardenTestSuite {

	
	@Test
	public void printflowerHashMap() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	      
	   DefineGarden garden = new DefineGarden("Test Garden");
	    garden.printFlowerHashMap();
	     
	     String expectedOutput  = "{marigolds=3, dandalions=6, begonias=8, sunflowers=10, roses=4}\n"; 

	     assertEquals(expectedOutput, outContent.toString());
	}
//	
//	@Test 
//	public void promptOutput() {
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	    System.setOut(new PrintStream(outContent));
//	      
//	    DefineGarden garden = new DefineGarden("Test Garden");
//	    //You can type any form of input into console
//	    garden.beginningPrompt();
//	     
//	    String expectedOutput  = "You can plant flowers, pick flowers, you have starter garden that you can check by using status and quit to go to a different location\nWhat would you like to do?\n"; 
//
//	    assertEquals(expectedOutput, outContent.toString());
//		
//	}
//	
	
	//tests to see if trying to pick/plant a flower not in the hashmap catches an error
//	@Test 
//	public void existingFlowerTest() {
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	    System.setOut(new PrintStream(outContent));
//	    
//	    DefineGarden garden = new DefineGarden("Test Garden");
//	    //for the following type in roses
//		garden.existingFlower("Tulip");
//		
//		String expectedOutput  = "Invalid Flower name! The valid flower names are: roses, dandalions, sunflowers, marigolds, begonias\n"; 
//	   assertEquals(expectedOutput, outContent.toString());
//
//	}
	
	@Test 
	public void invalidFlowerNumberTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    DefineGarden garden = new DefineGarden("Test Garden");
	    //for the following type in 1
		garden.invalidFlowerNumber("roses", Integer.MAX_VALUE);
		String expectedOutput  = "Invalid number of flowers. You cannot take more flowers than currently in the garden!\n"; 
	   assertEquals(expectedOutput, outContent.toString());

	}
	

	
	
	
	
	
	
	
	
	
}
