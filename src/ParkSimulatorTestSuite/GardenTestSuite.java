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

	
	 @Before
	 public void setup() {
		garden = new DefineGarden("Test Garden"); 
	}

	
	
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
	public void insertFlowerValidMultiple() {
		int accurateFlowerNumber = 0;
		garden.insertFlower("roses", 10);
		accurateFlowerNumber = garden.insertFlower("roses", 6);
		
		assertTrue(accurateFlowerNumber == 20);
	}

	
	@Test
	public void PickFlowerValid() {
		int accurateFlowerNumber = garden.extractFlowers("sunflowers", 1);
		
		assertTrue(accurateFlowerNumber == 9);
	}
	

	@Test
	public void PickFlowerValidMultiple() {
		int accurateFlowerNumber = 0;
		garden.extractFlowers("sunflowers", 2);
		accurateFlowerNumber = garden.extractFlowers("sunflowers", 2);
		assertTrue(accurateFlowerNumber == 6);
	}
	
	@Test 
	public void PickFlowerZero() {
		garden.extractFlowers("marigolds", 3);
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
		int result = garden.negativeInteger(-9);
		
		assertTrue(result==-1);
	}
	
	@Test 
	public void negativeIntegerCheckPositiveNumber() {
		int result = garden.negativeInteger(9);
		
		assertTrue(result==9);
	}
	
	
}
