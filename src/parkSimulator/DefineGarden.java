package parkSimulator;
import java.util.HashMap;
import java.util.Scanner;

public class DefineGarden extends Location {
	
	private String gardenName;
	private int numberOfFlowersInHashmap;
	private Scanner gardenUserInput;
	private HashMap<String,Integer> flowersInGarden;
	
	/**
	 * Constructor for a Garden Location
	 * @param name The location/garden name
	 * @return a DefineGarden object representing a garden
	 */
	public DefineGarden(String name) {
		super(name);
		this.gardenName = "Botanical Gardens";
		this.gardenUserInput = new Scanner(System.in);
		this.numberOfFlowersInHashmap = 0;
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
		System.out.println("Welcome to the " + gardenName + "!");
		promptGarden();
	}
	//option of adding a condition to the flowers where watering and fertilizing them increases the condition
	

	
	
	/**
	 * Prompt user for input regarding what activity they would like to do
	 */
	public void promptGarden() {
		System.out.println("You can plant flowers, pick flowers, use status to check your garden and quit to go to a different location");
		System.out.println("What would you like to do?");
		String promptInput = gardenUserInput.nextLine();
		
		
		
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
			printFlowerHashMap();
			System.out.println();
			promptGarden();
		}
		
		
	}
	
	public void addorPickPrompt (String promptInput) {
		System.out.println("What Flower would you like to " + promptInput + "?");
		String flowerName = gardenUserInput.nextLine();
		
		while (flowersInGarden.getOrDefault(flowerName, null) == null) {
			System.out.println("Invalid Flower name! The valid flower names are: roses, dandalions, sunflowers, marigolds, begonias");
			flowerName = gardenUserInput.nextLine();
		}
		
		
		if (promptInput.equals("pick")) {
			while (flowersInGarden.get(flowerName) == 0) {
				System.out.println("There are zero flowers! Try adding some flowers before picking!");
				flowerName = gardenUserInput.nextLine();
			}
				pickFlower(flowerName);
		}
		
		else if (promptInput.equals("plant")) {
			addFlower(flowerName);
		}
		
	}
	
	
	public void addFlower(String flowerName) {
		
		System.out.println("How many Flowers would you like to plant?");
		int flowerNumber = gardenUserInput.nextInt();
		
		if (flowersInGarden.containsKey(flowerName)) {
			flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) + flowerNumber);
			printFlowerHashMap();
			System.out.println();
			promptGarden();
		}
	}
	
	public void pickFlower(String flowerName) {
	
		System.out.println("How many Flowers would you like to pick?");
		int flowerNumber = gardenUserInput.nextInt();
		
		
		while (flowersInGarden.get(flowerName) < flowerNumber) {
			System.out.println("Invalid number of flowers. You cannot take more flowers than currently in the garden!");
			 flowerNumber = gardenUserInput.nextInt();
		}
		
		if (flowersInGarden.containsKey(flowerName)) {
			flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) - flowerNumber);
			printFlowerHashMap();
			System.out.println();
			promptGarden();
		}
		
	}
	
	/**
	 * Prints the hashmap of all of the flowers in the garden
	 */
	public void printFlowerHashMap() {
		System.out.println(flowersInGarden);
	}

}
