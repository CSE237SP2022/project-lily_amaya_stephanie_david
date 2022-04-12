package parkSimulator;

import java.util.Scanner;

public class DefineBasketballCourt extends Location {

	private Game newGame;
	private TrickShotGame otherGame;
	private Scanner locationInputScanner = new Scanner(System.in);

	/**
	 * Constructor for a Basketball court Location
	 * @param name The location/court name
	 * @return a DefineBasketballCourt object representing a Basketball Court location
	 */
	public DefineBasketballCourt(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Runs simulation of a basketball court
	 */
	public void basketballCourtSimulator() {
		chooseMode();
		


	}

	public void chooseMode() {
		String mode = prompt("Do you want to play HORSE or a game?");
		if(mode.equals( "game")) {
			String teamName = prompt("what is your team name?"); 
			newGame = new Game(teamName);
			System.out.print(newGame.simulateGame());
		}
		else if(mode.equals("HORSE") ||(mode.equals("horse"))) {
			otherGame = new TrickShotGame();
			System.out.print(otherGame.playGame());
			System.out.print(" You played HORSE ");
		}
		else {
			chooseMode();
		}
	}

	/**
	 * Prompt user for input regarding what action they would like to do
	 * @param message the message to print to the user
	 */
	public String prompt(String message) {

		Scanner locationInputScanner = new Scanner(System.in);
		System.out.print(message);
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;

	}

}
