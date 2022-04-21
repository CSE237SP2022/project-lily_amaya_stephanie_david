//I am not testing the prompt, basketballCourtSimulator, chooseMode, getRange, or round methods because they all require user input. 
//Testing these methods would essentially be testing to see if the Scanner works.
//Not testing TrickShotGame Classes because they are all reliant on math.random.
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
	private Game newGame;
	private TrickShotGame trickGame;

	@BeforeEach
	void setup() {
		basketballCourt = new DefineBasketballCourt("Basketball Court");
		newGame = new Game("team");
		trickGame = new TrickShotGame();
	}
	
	@Test
	void checkGameTestGame() {
		String userInputMode = "game";
		
		String wasGameProperlyChecked = basketballCourt.checkGame(userInputMode);
		
		assertEquals(wasGameProperlyChecked, "game");
	}
	
	@Test
	void checkGameTestHorse() {
		String userInputMode = "horse";
		
		String wasGameProperlyChecked = basketballCourt.checkGame(userInputMode);
		
		assertEquals(wasGameProperlyChecked, "horse");
	}
	
	@Test
	void checkGameTestLeave() {
		String userInputMode = "leave";
		
		String wasUserSentToEntrance = basketballCourt.checkGame(userInputMode);
		
		assertEquals(wasUserSentToEntrance, "leave");
	}
	
	@Test
	void checkGameTestInvalid() {
		String userInputMode = "invalid";
		
		String wasUserRePrompted = basketballCourt.checkGame(userInputMode);
		
		assertEquals(wasUserRePrompted, "invalid");
	}

	@Test
	void checkTest() {
		int probability = 90;
		int distance =  4;
		int lengthCheck = 5;
		boolean expectedOutput = true;
		boolean output = trickGame.check(lengthCheck, distance, probability);
		assertEquals(output, expectedOutput);
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

}
