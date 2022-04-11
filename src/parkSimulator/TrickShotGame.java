package parkSimulator;

import java.util.Scanner;

public class TrickShotGame {

	private String userScore;
	private String computerScore;
	private String returnMessage;
	private boolean userFirst;

	// TODO Auto-generated method stub
	public TrickShotGame() {
		this.userScore = "HORSE";
		this.computerScore = "HORSE";
		this.returnMessage = "";
		this.userFirst = true;
	}
	public String playGame() {
		System.out.println("You are playing horse. You and your opponent both have 5 lives represented by the word horse.");
		System.out.println("If you make a shot and your opponent misses they lose a letter");
		System.out.println("Put in an int from 1-50 to represent your distance from the hoop. As you get farther it will be less likely to go in");
		round(false,false,userFirst);
	}
	public boolean userTurn(boolean made, int distance) {
		if(made) {
			return takeShot(distance);
		}
		else {
			return takeShot(distance);
		}
	}

	public boolean computerTurn(boolean made, int distance) {
		if(made == true) {
			return takeShot(distance);
		}
		else {
			distance = (int) ((Math.random()*49)+1);
			return takeShot(distance);
		}
	}
	public void round(boolean userMade, boolean compMade, boolean userFirst) {
		if(userFirst == true) {
			System.out.print("user: " + this.userScore);
			System.out.print("computer: " + this.computerScore);
			int range = getRange("enter shot distance");
			userMade = userTurn(false, range);
			computerTurn(userMade, range);
		}
		if(userFirst == false) {
			System.out.print("user: " + this.userScore);
			System.out.print("computer: " + this.computerScore);
			System.out.print("computer goes first");
			compMade = computerTurn(false, 1); //doesn't work because need to get range from 
			userMade = userTurn(compMade, range);
			
		}
		
	}
	public int getRange(String message) {

		Scanner locationInputScanner = new Scanner(System.in);
		System.out.print(message);
		int range = locationInputScanner.nextInt();
		if((range < 1 )|| (range >50)) {
			return getRange(message);
		}
		else {
			return range;
		}
		

	}
	public boolean takeShot(int distance) {
		int prob = (int)((Math.random()*99)+1);
		if(distance < 5) {
			if (prob > 5) {
				return true;
			}
			else {
				return false;
			}
		}
		if(distance < 10) {
			if(prob > 20) {
				return true;
			}
			else {
				return false;
			}
		}
		if(distance < 20) {
			if(prob > 40) {
				return true;
			}
			else {
				return false;
			}
		}
		if(distance < 30) {
			if(prob > 60) {
				return true;
			}
			else {
				return false;
			}
		}
		if(distance < 40) {
			if(prob > 80) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(prob > 90) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}

