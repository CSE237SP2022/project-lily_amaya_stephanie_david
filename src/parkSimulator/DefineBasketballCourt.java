package parkSimulator;

import java.util.Scanner;

public class DefineBasketballCourt extends Location {

	private Game newGame;
	private TrickShotGame trickShotGame;
	private Scanner locationInputScanner = new Scanner(System.in);
	boolean userWantsToLeave = false;

	/**
	 * Constructor for a Basketball court Location
	 * @param name The location/court name
	 * @return a DefineBasketballCourt object representing a Basketball Court location
	 */
	public DefineBasketballCourt(String name) {
		super(name);
	}

	/**
	 * Runs simulation of a basketball court
	 */
	public void basketballCourtSimulator() {
		while(!userWantsToLeave) {
			chooseMode();
		}	
	}

	/**
	 * Prompt user for input regarding what game mode they would like to play and execute accordingly
	 */
	public void chooseMode() {
		String gameMode = "invalid";
		while(gameMode.equals("invalid")) {
			String userInputMode = prompt("Input HORSE to play a game of HORSE, input game to play a regular game, or input leave to return to the park entrance.");
			gameMode = checkGame(userInputMode);
		}	
		sendUser(gameMode);
	}

	private void sendUser(String gameMode) {
		if(gameMode.equals("game")){
			createAndPlayGame();
		}
		else if(gameMode.equals("horse")) {
			createAndPlayTrickShot();
		}
	}
	
	public String checkGame(String userInputMode) {
		if(userInputMode.equals( "game")) {
			return "game";
		}
		else if(userInputMode.equals("HORSE") ||(userInputMode.equals("horse"))) {
			return "horse";
		}
		else if(userInputMode.equals("leave")) {
			userWantsToLeave = true;
			return "leave";
		}
		else {
			System.out.println("Invalid game mode.");
			return "invalid";
		}
	}

	public void createAndPlayTrickShot() {
		trickShotGame = new TrickShotGame();
		System.out.println(trickShotGame.playGame());
		System.out.println(" You played HORSE ");
	}

	public void createAndPlayGame() {
		String teamName = prompt("what is your team name?"); 
		newGame = new Game(teamName);
		System.out.println(newGame.simulateGame());
	}

	/**
	 * Prompt user for input regarding what action they would like to do
	 * @param message the message to print to the user
	 */
	public String prompt(String message) {
		Scanner locationInputScanner = new Scanner(System.in);
		System.out.println(message);
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;
	}

}
