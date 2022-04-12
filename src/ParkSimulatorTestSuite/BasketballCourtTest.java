 
	
	package ParkSimulatorTestSuite;

	import static org.junit.jupiter.api.Assertions.*;

	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
	import java.util.Scanner;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import parkSimulator.*;

	class BasketballCourtTest {
	private DefineBasketballCourt basketballCourt;
	private Game newGame = new Game("team");

	@BeforeEach
	void setup() {
	basketballCourt = new DefineBasketballCourt("Basketball Court");
	}

	@Test
	void listOptionsTest() {
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	   System.setOut(new PrintStream(outContent));
	   String testString = "what is your team name?";
	   basketballCourt.prompt(testString);
	   String expectedOutput  = "what is your team name?";
	   
	   assertEquals(expectedOutput, outContent.toString().trim());
	}
	@Test
	
	void scoreTest() {
	int output =  newGame.randomScore();
	String testing = output + "";
	   int expectedOutput = Integer.parseInt(testing);
	   assertEquals(output, expectedOutput);
	}
	
	@Test
	void gameTest() {
		String output =  newGame.simulateGame();
		boolean testing =(output instanceof String);
		boolean expected = true;
		   assertEquals(testing, expected);
		}
//	@Test
//	void petBunnyTest() {
//	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	   System.setOut(new PrintStream(outContent));
//
//	   pettingZoo.petBunny();
//	   String expectedOutput  = "You are petting a bunny! The bunny's name is Fluffy. She seems happy :)";
//
//	   assertEquals(expectedOutput, outContent.toString().trim());
//	}
//	@Test
//	void petBunnyTest() {
//	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	   System.setOut(new PrintStream(outContent));
//
//	   pettingZoo.petBunny();
//	   String expectedOutput  = "You are petting a bunny! The bunny's name is Fluffy. She seems happy :)";
//
//	   assertEquals(expectedOutput, outContent.toString().trim());
//	}

}
