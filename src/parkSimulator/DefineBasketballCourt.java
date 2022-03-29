package parkSimulator;

import java.util.Scanner;

public class DefineBasketballCourt extends Location {

	private Game newGame;
	private Scanner locationInputScanner = new Scanner(System.in);

	public DefineBasketballCourt(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void basketballCourtSimulator() {
		String teamName = prompt("what is your team name?"); 
		newGame = new Game(teamName);
		System.out.print(newGame.simulateGame(newGame.team));


	}

	public String prompt(String message) {

		Scanner locationInputScanner = new Scanner(System.in);
		System.out.print(message);
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;

	}

}
