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
			System.out.println(message);
			listOptions();
			return userInputScanner.nextLine();
	}
	
	/**
	 * Change the location of the user and execute appropriate method representing the new location
	 * @param userInput a String containing the data the user inputs
	 */
	public void sendUserToLocation(String userInput) {
		if(userInput.equals("leave petting zoo")) {
			userWantsToLeave = true;
		}
		else if(userInput.equals("pet")) {
			pet();
		}
		else if(userInput.equals("feed")) {
			feed();
		}
		else {
			System.out.print("Invalid input.\n\n");
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
	
	/**
	 * Calls prompt to see which animal the user wants to pet and calls the appropriate method
	 */
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
	 * Asks the user what animal they want to pet
	 * @return a String with the user's input
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
		System.out.println("You are petting a bunny! The bunny's name is Fluffy. She seems happy :)\n");
		message = "What would you like to do next?";
	}
	
	/**
	 * Simulates petting a penguin
	 */
	public void petPenguin() {
		System.out.println("You are petting a penguin! The penguin's name is Guiseppe. Guiseppe is happily flapping his wings :)\n");
		message = "What would you like to do next?";
	}
	
	/**
	 * Simulates trying to pet a fish
	 */
	public void petFish() {
		System.out.println("You are trying to pet the fish. The fish's name is Harold. Harold is confused but appreciates the attention. Your hand is wet now.\n");
		message = "What would you like to do next?";
	}
	
	/**
	 * Simulates petting a puppy
	 */
	public void petPuppy() {
		System.out.println("You are petting the puppy! The puppy's name Donovan. Donovan is VERY happy!! He's excitedly wagging his tail!\n");
		boolean bellyRubPossibility = rollForBellyRubPotential(2); //50% chance of getting a belly rub
		if(bellyRubPossibility) {
			bellyRubPrompt();
		}
		message = "What would you like to do next?";
	}

	/**
	 * Asks the user if they would like to give the puppy a belly rub
	 */
	private void bellyRubPrompt() {
		System.out.println("What's this?!? Harold is rolling over on the ground in front of you. It looks like Harold wants a belly rub!\n");
		boolean invalidBellyRubInput = true;
		while(invalidBellyRubInput) {
			System.out.println("Will you give Harold a belly rub? (yes/no)");
			String userBellyRubResponse = userInputScanner.nextLine();
			if(userBellyRubResponse.equals("yes")) {
				System.out.println("Good choice!! Harold looks very happy :)\n");
				invalidBellyRubInput = false;
			}
			else if(userBellyRubResponse.equals("no")) {
				System.out.println("Harold looks disappointed but respects your boundaries.\n");
				invalidBellyRubInput = false;
			}
			else {
				System.out.println("Invalid input. Please try again\n");
			}
		}
	}
	
	/**
	 * Randomly determines whether the puppy wants a belly rub
	 * @param howLikely an int representing the chances of getting a belly rub potential
	 * @return a boolean that stores whether the puppy wants a belly rub
	 */
	public boolean rollForBellyRubPotential(int howLikely) {
		int random_int = (int)Math.floor(Math.random()*(howLikely)+1);
		if(random_int == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calls prompt to see which animal the user wants to feed and calls the appropriate method
	 */
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
	
	/**
	 * Asks the user what animal they want to feed
	 * @return a String with the user's input
	 */
	public String promptFeed(){
		System.out.print("The animals can feed are: ");
		for(String animal : animals) {
			System.out.print(animal + " ");
		}
		System.out.println();
		System.out.println("Input the animal you would like to feed.");
		return userInputScanner.nextLine();
	}
	
	/**
	 * Simulates feeding a bunny
	 */
	public void feedBunny() {
		System.out.println("You are feeding the bunny, Fluffy, some grass. This is Fluffy's favorite food. Fluffy seems thankful!\n");
	}
	
	/**
	 * Simulates feeding a penguin
	 */
	public void feedPenguin() {
		System.out.println("You are feeding the penguin, Guiseppe, some krill. Guiseppe really likes this food, and now Guiseppe likes you, too!\n");
	}
	
	/**
	 * Simulates feeding a fish
	 */
	public void feedFish() {
		System.out.println("You are feeding the fish, Harold, some fish food. Harold seems to like the food. He isn't very emotive, but I'm sure he appreciates it.\n");
	}
	
	/**
	 * Simulates feeding a puppy
	 */
	public void feedPuppy() {
		System.out.println("You are feeding the puppy, Donovan, some dog treats. Dononvan is eats them very quickly. He is very happy!\n");
		boolean bellyRubPossibility = rollForBellyRubPotential(4); //25% chance of getting a belly rub
		if(bellyRubPossibility) {
			bellyRubPrompt();
		}
	}
}
