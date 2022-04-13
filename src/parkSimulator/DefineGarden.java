package parkSimulator;
import java.util.HashMap;
import java.util.Scanner;

public class DefineGarden extends Location {
	
	private int numberOfFlowersInHashmap;
	private Scanner gardenUserInput;
	private HashMap<String,Integer> flowersInGarden;
	private String promptInput;
	
	/**
	 * Constructor for a Garden Location
	 * @param name The location/garden name
	 * @return a DefineGarden object representing a garden
	 */
	public DefineGarden(String name) {
		super(name);
		
		this.gardenUserInput = new Scanner(System.in);
		this.promptInput = "";
		this.flowersInGarden = new HashMap<String, Integer>() {{
			put("roses", 4);
			put("dandalions", 6);
			put("sunflowers", 10);
			put("marigolds", 3);
			put("begonias", 8);
		}};
		
	}
	
	/**
	 * Runs simulation of a garden location
	 */
	public void gardenSimulator() {
		System.out.println("Welcome to the Botanical Gardens!");
		promptGarden();
	}
	
	/**
	 * Prompt user for input regarding what activity they would like to do
	 */
	public void promptGarden() {
		
		beginningPrompt();
		if (promptInput.equals("plant") || promptInput.equals("pick")) {
			addorPickPrompt(promptInput);
		}
		if (promptInput.equals("quit")) {
			
		}
		if (promptInput.equals("")){
			promptInput = gardenUserInput.nextLine();
			promptGarden();
		}
		while (!(promptInput.equals("pick")) && !(promptInput.equals("plant")) && !(promptInput.equals("status")) && !(promptInput.equals("quit"))) {
			System.out.println("Invalid Input! You can plant and pick flowers, and you can use status to check the status of your garden");
			 promptInput = gardenUserInput.nextLine();
		}
		if (promptInput.equals("status")) {
			startOver();
		}
		
		
	}
	
	/**
	 * Provide initial info to the user and prompt for what action to perform
	 */
	public void beginningPrompt() {
		System.out.println("You can plant flowers, pick flowers, you have starter garden that you can check by using status and quit to go to a different location");
		System.out.println("What would you like to do?");
		promptInput = gardenUserInput.nextLine();
	}
	
	/**
	 * Prompt user for the flower they want to perform an action for and execute that action accordingly
	 * @param promptInput The action the user is performing for whichever flower they input
	 */
	public void addorPickPrompt (String promptInput) {
		System.out.println("What Flower would you like to " + promptInput + "?");
		String flowerName = gardenUserInput.nextLine();
		
		existingFlower(flowerName);
		
		if (promptInput.equals("pick")) {
			zeroFlowers(flowerName);
				pickFlower(flowerName);
		}
		
		else if (promptInput.equals("plant")) {
			addFlower(flowerName);
		}
		
	}
	
	/**
	 * Reprompt user if they try to pick flowers that have a quantity of zero in the garden
	 * @param flowerName the flower the user is trying to pick
	 */
	public void zeroFlowers (String flowerName) {
		while (flowersInGarden.get(flowerName) == 0) {
			System.out.println("There are zero flowers! Try adding some flowers before picking!");
			flowerName = gardenUserInput.nextLine();
		}
	}
	
	/**
	 * Reprompt user if they input the name of a flower that isn't in the garden
	 * @param flowerName the name of the flower to check in the garden
	 */
	public void existingFlower(String flowerName) {
		while (flowersInGarden.getOrDefault(flowerName, null) == null) {
			System.out.println("Invalid Flower name! The valid flower names are: roses, dandalions, sunflowers, marigolds, begonias");
			flowerName = gardenUserInput.nextLine();
		}
	}
	
	/**
	 * Prompt user to plant flower(s)
	 * @param flowerName the type of flower the user is trying to plant
	 */
	public void addFlower(String flowerName) {
		
		System.out.println("How many Flowers would you like to plant?");
		int flowerNumber = gardenUserInput.nextInt();
		if (flowersInGarden.containsKey(flowerName)) {
			flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) + flowerNumber);
			startOver();
		}
		
	}
	
	
	/**
	 * Prompt user to pick flower(s)
	 * @param flowerName the flower the user is trying to take
	 */
	public void pickFlower(String flowerName) {
	
		System.out.println("How many Flowers would you like to pick?");
		int flowerNumber = gardenUserInput.nextInt();
		
		invalidFlowerNumber(flowerName, flowerNumber);
		if (flowersInGarden.containsKey(flowerName)) {
			flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) - flowerNumber);
			startOver();
		}
		
	}
	
	/**
	 * Reprompt user until a valid number of flowers is given
	 * @param flowerName the flower the user is trying to take
	 * @param flowerNumber the number of flowers the user is trying to take
	 */
	public void invalidFlowerNumber(String flowerName, int flowerNumber) {
		while (flowersInGarden.get(flowerName) < flowerNumber) {
			System.out.println("Invalid number of flowers. You cannot take more flowers than currently in the garden!");
			 flowerNumber = gardenUserInput.nextInt();
		}
	}
	
	/**
	 * Print the flower hash map and prompt user
	 */
	public void startOver () {
		printFlowerHashMap();
		System.out.println();
		promptGarden();
	}
	
	
	/**
	 * Prints the hashmap of all of the flowers in the garden
	 */
	public void printFlowerHashMap() {
		System.out.println(flowersInGarden);
	}

}
