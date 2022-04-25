package parkSimulator;

import java.util.Scanner;

public class TrickShotGame {

	private int userScore;
	private int computerScore;
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
		this.userScore = 5;
		this.computerScore = 5;
		this.returnMessage = "";
		this.userFirst = true;
	}
	/**
	 * starts the actual game
	 * @returns String representing how the game went
	 */
	public String playGame(){
		System.out.println("You are playing horse. You and your opponent both have 5 lives represented by the word horse.");
		System.out.println("If you make a shot and your opponent misses they lose a letter");
		System.out.println("Put in an int from 1-50 to represent your distance from the hoop. As you get farther it will be less likely to go in");
		round(true);
		return " good game! ";
	}
	/**
	 * 
	 * @param made whether or not the computer made their last shot
	 * @param distance range of basketball shot
	 * @return boolean representing whether the user made this shot
	 */
	public boolean userTurn(int distance) {
		System.out.println(" The user is now shooting ");
		return takeShot(distance);

	}
	/**
	 * 
	 * @param made whether or not the user made their last shot
	 * @param distance range of basketball shot
	 * @return boolean representing whether the computer made this shot
	 */
	public boolean computerTurn(int distance){
		System.out.println(" The computer is now shooting ");
		return takeShot(distance);
	}

	/**
	 * 
	 * @param userMade boolean if user made a shot
	 * @param compMade boolean if computer made a shot
	 * @param userFirst boolean turn order
	 */
	public void round(boolean userFirst){
		if(this.computerScore == 0) {
			System.out.println("You Win");
		}
		else if(this.userScore == 0) {
			System.out.println("Computer Wins");
		}
		else {
			if(userFirst) {
				System.out.println("user: " + returnScoreString(this.userScore) + " ");
				System.out.println("computer: " + returnScoreString(this.computerScore) + " ");
				System.out.println("user goes first");
				getRange("enter shot distance");

				boolean userMade = userTurn(this.range);
				if(userMade) {
					boolean compMade = computerTurn(this.range);
					if(compMade) {
						round(true);
					}
					else {
						this.computerScore--;
						round(true);
					}
				}
				else {
					round(false);
				}
			}
			else {
				System.out.println("user: " + returnScoreString(this.userScore) + " ");

				System.out.println("computer: " + returnScoreString(this.computerScore) + " ");
				System.out.println("computer goes first");
				this.range = (int) ((Math.random()*49)+1);
				boolean compMade = computerTurn(this.range);
				if(compMade) {
					boolean userMade = userTurn(this.range);
					if(userMade) {
						round(false);
					}
					else {
						this.userScore--;
						round(false);
					}
				}
				else {
					round(true);
				}
			}
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
			if(distance > 50) {
				if(probability > 95) {
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
			System.out.println("Missed! ");

			return false;
		}
		System.out.println("The shot went in! Distance: " + this.range + " ");
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

	/**
	 * 
	 * @param score int representing amount of points remaining
	 * @return String version of score
	 */
	public String returnScoreString(int score) {
		if(score == 5) {
			return "HORSE";
		}
		if(score == 4) {
			return "HORS";
		}
		if(score == 3) {
			return "HOR";
		}
		if(score == 2) {
			return "HO";
		}
		if(score == 1) {
			return "H";
		}
		else {
			return "";
		}

	}
	
}

