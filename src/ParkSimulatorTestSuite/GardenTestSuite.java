package ParkSimulatorTestSuite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Scanner;
import parkSimulator.DefineGarden;



public class GardenTestSuite {

	
	private DefineGarden garden;
	//private HashMap<String,Integer> flowersInGarden;

	
	 @Before
	 public void setup() {
		garden = new DefineGarden("Test Garden"); 
	}
	//need a way to add or initialize flowers in the garden

	
	
	@Test
	public void printflowerHashMap() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	      
	    garden.printFlowerHashMap();
	     
	    String expectedOutput  = "{marigolds=3, dandalions=6, begonias=8, sunflowers=10, roses=4}\n\n"; 

	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test 
	public void existingFlowerTestValid() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		String flowerName = garden.existingFlower("roses");
		
		assertTrue(flowerName.equals("roses"));
	}
	
	@Test 
	public void ExistingFlowerTestInvalid() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		String flowerName = garden.existingFlower("Tulips");
		
		assertTrue(flowerName.equals("null"));
	}
	
	
	@Test
	public void insertFlowerValid() {
		int accurateFlowerNumber = garden.insertFlower("roses", 10);
		assertTrue(accurateFlowerNumber == 14);
	}


	
	@Test
	public void PickFlowerValid() {
		int accurateFlowerNumber = garden.updatedPickFlower("sunflowers", 1);
		assertTrue(accurateFlowerNumber == 9);
	}
	
	@Test 
	public void PickFlowerZero() {
		garden.updatedPickFlower("marigolds", 3);
		String result = garden.zeroFlowers("marigolds");
		assertTrue(result.equals("null"));
	}

	@Test 
	public void PickFlowerNonZero() {
		String result = garden.zeroFlowers("marigolds");
		assertTrue(result.equals("marigolds"));
	}
	

	@Test 
	public void validFlowerNumberTest() {
		int accurateFlowerNumber = garden.invalidFlowerNumber("sunflowers", 1);
		assertTrue(accurateFlowerNumber == 1);
	}
	
	public void invalidFlowerNumberTest() {
		int accurateFlowerNumber = garden.invalidFlowerNumber("sunflowers", 100);
		assertTrue(accurateFlowerNumber == -1);
	}
	
	@Test 
	public void negativeIntegerCheckNegativeNumber() {
		int result = garden.checkNegativeInteger(-9);
		assertTrue(result==-1);
	}
	
	@Test 
	public void negativeIntegerCheckPositiveNumber() {
		int result = garden.checkNegativeInteger(9);
		assertTrue(result==9);
	}
	
	
//	@Test 
//	public void checkIntegerValidNumber() {
//		int result = garden.checkValidInteger();
//		assertTrue(result==);
//	}
	

	//existingFlower
	//zeroFlowers
	//getFLowerNumber
	//InvalidFlowerNumber
	//checkValidInteger
	//checkNegativeInteger
	
	
	
	
	
	
	
	
}
