package parkSimulator;

import java.util.Scanner;

public class Simulator {
	private boolean validUserInputLocation = false;
	private Scanner locationInputScanner = new Scanner(System.in);

	public static void main(String[] args) {
		String locationInputString = prompt("Welcome to the park! Where would you like to go?"); //this does not work right now. We should move the non-static methods to the Park class
		getUserLocation(locationInputString,);
	}

	private void getUserLocation(String locationInputString) {
		while(!validUserInputLocation) {
			if(locationInputString.equals("garden")) {
				validUserInputLocation = true;
				gardenSimulator();
			}
			else if(locationInputString.equals("petting zoo")) {
				validUserInputLocation = true;
				pettingZooSimulator();
			}
			else if(locationInputString.equals("basketball court")) {
				validUserInputLocation = true;
				basketballCourtSimulator();
			}
			else if(locationInputString.equals("pool")) {
				validUserInputLocation = true;
				poolSimulator();
			}
			else {
				locationInputString = prompt("Invalid location. Please enter a valid location.");
			}
		}
	}

	private String prompt(String message) {
		System.out.println(message + " Options are: garden, petting zoo, basketball court, pool");
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;
	}
}
