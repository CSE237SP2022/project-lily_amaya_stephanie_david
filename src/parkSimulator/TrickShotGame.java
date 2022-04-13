package parkSimulator;

import java.util.Scanner;

public class TrickShotGame {

	private String userScore;
	private String computerScore;
	private String returnMessage;
	private boolean userFirst;
	private int range;
	private boolean missed;

	// TODO Auto-generated method stub
	/**
	 * Constructor
	 * Initializes scores and sets up first turn
	 */
	public TrickShotGame() {
		this.userScore = "HORSE";
		this.computerScore = "HORSE";
		this.returnMessage = "";
		this.userFirst = true;
	}
	/**
	 * starts the actual game
	 * @returns String representing how the game went
	 */
	public String playGame() {
		System.out.println("You are playing horse. You and your opponent both have 5 lives represented by the word horse.");
		System.out.println("If you make a shot and your opponent misses they lose a letter");
		System.out.println("Put in an int from 1-50 to represent your distance from the hoop. As you get farther it will be less likely to go in");
		round(false,false,userFirst);
		return " not working yet ";
	}
	/**
	 * 
	 * @param made whether or not the computer made their last shot
	 * @param distance range of basketball shot
	 * @return boolean representing whether the user made this shot
	 */
	public boolean userTurn(boolean made, int distance) {
		if(made) {
			return takeShot(distance);
		}
		else {
			return takeShot(distance);
		}
	}
	/**
	 * 
	 * @param made whether or not the user made their last shot
	 * @param distance range of basketball shot
	 * @return boolean representing whether the computer made this shot
	 */
	public boolean computerTurn(boolean made, int distance) {
		if(made == true) {
			return takeShot(distance);
		}
		else {
			distance = (int) ((Math.random()*49)+1);
			return takeShot(distance);
		}
	}
	/**
	 * 
	 * @param userMade boolean if user made a shot
	 * @param compMade boolean if computer made a shot
	 * @param userFirst boolean turn order
	 */
	public void round(boolean userMade, boolean compMade, boolean userFirst) {

		if(userFirst == true) {
			System.out.print("user: " + this.userScore + " ");
			System.out.println("computer: " + this.computerScore + " ");
			getRange("enter shot distance");
			userMade = userTurn(false, this.range);
			this.userFirst = !computerTurn(userMade, this.range);
		}
		if(userFirst == false) {
			System.out.print("user: " + this.userScore);
			System.out.print("computer: " + this.computerScore);
			System.out.print("computer goes first");
			compMade = computerTurn(false, this.range);
			this.userFirst = userMade = userTurn(compMade, this.range);

		}

	}
	/**
	 * prompt user for distance to shoot
	 * @param message String to be shown to user
	 */
	public void getRange(String message) {

		Scanner locationInputScanner = new Scanner(System.in);
		System.out.print(message);
		boolean validNum = false;
		int range = 0;
		while(validNum == false) {
			range = locationInputScanner.nextInt();
			if((range < 1 )|| (range >50)) {

			}
			else {
				this.range = range;
				validNum = true;
			}
		}



	}
	/**
	 * 
	 * @param distance range of basketball shot
	 * @return boolean if shot went in
	 */
	public boolean takeShot(int distance) {
		int probability = (int)((Math.random()*99)+1);
		int lengthCheck = 5;
		boolean tookShot = false;
		this.missed = false;
		while(tookShot == false) {
			if(distance > 40) {
				if(probability > 90) {
					this.range = distance;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				tookShot = check(lengthCheck, distance, probability);
				lengthCheck = lengthCheck*2;
			}
		}
		if(this.missed == true) {
			System.out.print("Missed ! ");

			return false;
		}
		System.out.print("The shot went in! Distance: " + this.range);
		return true;

	}

	/**
	 * 
	 * @param lengthCheck int increasing value allowing for decreasing probability with farther shots
	 * @param distance int range
	 * @param probability int representing the "roll" the user had with their shot
	 * @return boolean if the shot went in
	 */
	public boolean check(int lengthCheck, int distance, int probability) {
		if(distance < lengthCheck) {
			if(probability > lengthCheck*2) {

				this.missed = false;
				this.range = distance;
				return true;
			}
			else {
				this.missed = true;
				return true;
			}
		}
		return false;

	}
}

