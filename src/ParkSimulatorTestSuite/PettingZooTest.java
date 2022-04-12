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
	//I am not testing the prompt, pettingZooSimulator, promptPet, promptFeed, or bellyRubPrompt methods because they all require user input. 
	//Testing these methods would essentially be testing to see if the Scanner works.
	
	//I am currently not testing the pet or feed method yet because they use user input. In the next iteration, I plan to extract the user input part 
	//from these methods.
	//The petPuppy and feedPuppy methods sometimes require user input (depending on whether the puppy wants a belly rub). In a future iteration, I will 
	//try to come up with a way to test these method. 
	
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
	    String expectedOutput  = "Input \"pet\" to pet an animal."
				+ "\nInput \"feed\" to feed an animal"
				+ "\nInput \"leave petting zoo\" to return to the park entrance.";
	    
	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void sendUserToLocationTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.sendUserToLocation("invalid");
	    String expectedOutput  = "Invalid input.";

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
	void petPenguinTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.petPenguin();
	    String expectedOutput  = "You are petting a penguin! The penguin's name is Guiseppe. Guiseppe is happily flapping his wings :)";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void petFishTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.petFish();
	    String expectedOutput  = "You are trying to pet the fish. The fish's name is Harold. Harold is confused but appreciates the attention. Your hand is wet now.";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void feedBunnyTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.feedBunny();
	    String expectedOutput  = "You are feeding the bunny, Fluffy, some grass. This is Fluffy's favorite food. Fluffy seems thankful!";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void feedPenguinTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.feedPenguin();
	    String expectedOutput  = "You are feeding the penguin, Guiseppe, some krill. Guiseppe really likes this food, and now Guiseppe likes you, too!";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void feedFishTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    pettingZoo.feedFish();
	    String expectedOutput  = "You are feeding the fish, Harold, some fish food. Harold seems to like the food. He isn't very emotive, but I'm sure he appreciates it.";

	    assertEquals(expectedOutput, outContent.toString().trim());
	}
	
	@Test
	void rollForBellyRubPotentialZeroPrecentTest() {
	    boolean wasThereABellyRub  = pettingZoo.rollForBellyRubPotential(Integer.MAX_VALUE); //(essentially) 0% chance of getting a belly rub
	    boolean expectedOutput = false;
	    assertEquals(expectedOutput, wasThereABellyRub);
	}
	
	@Test
	void rollForBellyRubPotentialOneHundredPrecentTest() {
	    boolean wasThereABellyRub  = pettingZoo.rollForBellyRubPotential(1); //100% chance of getting a belly rub
	    boolean expectedOutput = true;
	    assertEquals(expectedOutput, wasThereABellyRub);
	}
}
