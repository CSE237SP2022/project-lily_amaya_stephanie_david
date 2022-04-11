package parkSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefinePettingZoo extends Location{
	boolean userWantsToLeave = false;
	Scanner userInputScanner = new Scanner(System.in);
	List<String> animals = new ArrayList<String>();
	String message;
	
	/**
	 * Constructor for Petting Zoo location
	 * @param name The location/petting zoo name
	 * @return a DefinePettingZoo object representing a petting zoo location
	 */
	public DefinePettingZoo(String name) {
		super(name);
		animals.add("bunny");
		animals.add("penguin");
		animals.add("fish");
		animals.add("puppy");
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
		else if(userInput.equals("pet")) {
			pet();
		}
		else if(userInput.equals("feed")) {
			feed();
		}
		else {
			System.out.print("Invalid input.\n");
		}
	}
	
	/**
	 * List descriptions of the activities the user can do
	 */
	public void listOptions() {
		System.out.println("Input \"pet\" to pet an animal."
				+ "\nInput \"feed\" to feed an animal"
				+ "\nInput \"leave petting zoo\" to return to the park entrance.");
		message = "What would you like to do?";
	}
	
	public void pet() {
		boolean invalidAnimalToPet = true;
		while(invalidAnimalToPet) {
			String userInputAnimalToPet = promptPet();
			if(userInputAnimalToPet.equals("bunny")) {
				petBunny();
				invalidAnimalToPet = false;
			}
			else if(userInputAnimalToPet.equals("penguin")) {
				petPenguin();
				invalidAnimalToPet = false;
			}
			else if(userInputAnimalToPet.equals("fish")) {
				petFish();
				invalidAnimalToPet = false;
			}
			else if(userInputAnimalToPet.equals("puppy")) {
				petPuppy();
				invalidAnimalToPet = false;
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String promptPet(){
		System.out.print("The animals can pet are: ");
		for(String animal : animals) {
			System.out.print(animal + " ");
		}
		System.out.println();
		System.out.println("Input the animal you would like to pet.");
		return userInputScanner.nextLine();
	}
	
	/**
	 * Simulates petting a bunny
	 */
	public void petBunny() {
		System.out.println("You are petting a bunny! The bunny's name is Fluffy. She seems happy :)");
		message = "What would you like to do next?";
	}
	
	public void petPenguin() {
		System.out.println("You are petting a penguin! The penguin's name is Guiseppe. Guiseppe is happily flapping his wings :)");
		message = "What would you like to do next?";
	}
	
	public void petFish() {
		System.out.println("You are trying to pet the fish. The fish's name is Harold. Harold is confused but appreciates the attention. Your hand is wet now.");
		message = "What would you like to do next?";
	}
	
	public void petPuppy() {
		System.out.println("You are petting the puppy! The puppy's name Donovan. Donovan is VERY happy!! He's excitedly wagging his tail!");
		boolean bellyRubPossibility = rollForBellyRubPotential(2); //50% chance of getting a belly rub
		if(bellyRubPossibility) {
			bellyRubPrompt();
		}
		message = "What would you like to do next?";
	}

	private void bellyRubPrompt() {
		System.out.println("What's this?!? Harold is rolling over on the ground in front of you. It looks like Harold wants a belly rub!");
		boolean invalidBellyRubInput = true;
		while(invalidBellyRubInput) {
			System.out.println("Will you give Harold a belly rub? (yes/no)");
			String userBellyRubResponse = userInputScanner.nextLine();
			if(userBellyRubResponse.equals("yes")) {
				System.out.println("Good choice!! Harold looks very happy :)");
				invalidBellyRubInput = false;
			}
			else if(userBellyRubResponse.equals("no")) {
				System.out.println("Harold looks disappointed but respects your boundaries.");
				invalidBellyRubInput = false;
			}
			else {
				System.out.println("Invalid input. Please try again");
			}
		}
	}
	
	public boolean rollForBellyRubPotential(int howLikely) {
		int random_int = (int)Math.floor(Math.random()*(howLikely)+1);
		if(random_int == 1) {
			return true;
		}
		return false;
	}
	
	public void feed() {
		boolean invalidAnimalToFeed = true;
		while(invalidAnimalToFeed) {
			String userInputAnimalToFeed = promptFeed();
			if(userInputAnimalToFeed.equals("bunny")) {
				feedBunny();
				invalidAnimalToFeed = false;
			}
			else if(userInputAnimalToFeed.equals("penguin")) {
				feedPenguin();
				invalidAnimalToFeed = false;
			}
			else if(userInputAnimalToFeed.equals("fish")) {
				feedFish();
				invalidAnimalToFeed = false;
			}
			else if(userInputAnimalToFeed.equals("puppy")) {
				feedPuppy();
				invalidAnimalToFeed = false;
			}
		}
		message = "What would you like to do next?";
	}
	
	public String promptFeed(){
		System.out.print("The animals can feed are: ");
		for(String animal : animals) {
			System.out.print(animal + " ");
		}
		System.out.println();
		System.out.println("Input the animal you would like to feed.");
		return userInputScanner.nextLine();
	}
	
	public void feedBunny() {
		System.out.println("You are feeding the bunny, Fluffy, some grass. This is Fluffy's favorite food. Fluffy seems thankful!");
	}
	
	public void feedPenguin() {
		System.out.println("You are feeding the penguin, Guiseppe, some krill. Guiseppe really likes this food, and now Guiseppe likes you, too!");
	}
	
	public void feedFish() {
		System.out.println("You are feeding the fish, Harold, some fish food. Harold seems to like the food. He isn't very emotive, but I'm sure he appreciates it.");
	}
	
	public void feedPuppy() {
		System.out.println("You are feeding the puppy, Donovan, some dog treats. Dononvan is eats them very quickly. He is very happy!");
		boolean bellyRubPossibility = rollForBellyRubPotential(4); //25% chance of getting a belly rub
		if(bellyRubPossibility) {
			bellyRubPrompt();
		}
	}
}
