package parkSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefinePettingZoo extends Location{
	boolean userWantsToLeave = false;
	Scanner userInputScanner = new Scanner(System.in);
	String message;
	
	/**
	 * Constructor for Petting Zoo location
	 * @param name The location/petting zoo name
	 * @return a DefinePettingZoo object representing a petting zoo location
	 */
	public DefinePettingZoo(String name) {
		super(name);
		message = "Welcome to the petting zoo! What would you like to do?";
	}
	
	/**
	 * Runs a simulation of a petting zoo
	 */
	public void pettingZooSimulator(){
		while(!userWantsToLeave) {
			String userInput = prompt();	
			sendUserToLocation(userInput);
		}
	}

	/**
	 * Prompt user for input regarding what action they would like to do
	 */
	public String prompt() {
			System.out.println(message + " (Input \"options\" to see what you can do)");
			return userInputScanner.nextLine();
	}
	
	/**
	 * Change the location of the user and execute appropriate method representing the new location
	 * @param userInput a String containing the data the user inputs
	 */
	public void sendUserToLocation(String userInput) {
		if(userInput.equals("options")) {
			listOptions();
		}
		else if(userInput.equals("leave petting zoo")) {
			userWantsToLeave = true;
		}
		else if(userInput.equals("pet bunny")) {
			petBunny();
		}
		else {
			System.out.print("Invalid input. What would you like to do?");
		}
	}
	
	/**
	 * List descriptions of the activities the user can do
	 */
	public void listOptions() {
		System.out.println("Input \"pet bunny\" to pet the bunny."
				+ "\nInput \"leave petting zoo\" to return to the park entrance.");
		message = "What would you like to do?";
	}
	
	/**
	 * Simulates petting a bunny
	 */
	public void petBunny() {
		System.out.println("You are petting a bunny! The bunny's name is Fluffy. She seems happy :)");
		message = "What would you like to do next?";
	}
	
}
