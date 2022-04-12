package parkSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefinePettingZoo extends Location{
	boolean userWantsToLeave = false;
	Scanner userInputScanner = new Scanner(System.in);
	String message;
	
	public DefinePettingZoo(String name) {
		super(name);
		message = "Welcome to the petting zoo! What would you like to do?";
	}
	
	void pettingZooSimulator(){
		while(!userWantsToLeave) {
			String userInput = prompt();	
			sendUserToLocation(userInput);
		}
	}

	private String prompt() {
			System.out.println(message + " (Input \"options\" to see what you can do");
			return userInputScanner.nextLine();
	}
	
	private void sendUserToLocation(String userInput) {
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
			message = "Invalid input. What would you like to do?";
		}
	}
	
	private void listOptions() {
		System.out.println("Input \"pet bunny\" to pet the bunny."
				+ "\nInput \"leave petting zoo\" to return to the park entrance.");
		message = "What would you like to do?";
	}
	
	private void petBunny() {
		System.out.println("You are petting a bunny! The bunny's name is Fluffy. She seems happy :)");
		message = "What would you like to do next?";
	}
	
}
