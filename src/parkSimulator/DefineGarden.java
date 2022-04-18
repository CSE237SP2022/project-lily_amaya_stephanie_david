package parkSimulator;
import java.util.HashMap;
import java.util.Scanner;

public class DefineGarden extends Location {
	
	private int numberOfFlowersInHashmap;
	private Scanner gardenUserInput;
	private HashMap<String,Integer> flowersInGarden;
	private String promptInput;
	
	
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
	
	
	public void gardenSimulator() {
		System.out.println("Welcome to the Botanical Gardens! Here is your garden:");
		printFlowerHashMap();
		promptGarden();
	}
	
	
	public void promptGarden() {
		beginningPrompt();
		validPlantOrPick();
		inputQuit();
		invalidInput();
		inputStatus();
	}
	
	
	public void beginningPrompt() {
		System.out.println("You can type plant, pick, status or quit to plant/pick flowers, check the status of the garden or go to a different location");
		System.out.println("What would you like to do?");
		promptInput = gardenUserInput.nextLine();
	}
	
	public void inputStatus() {
		if (promptInput.equals("status")) {
			startOver();
		}
	}
	
	
	public void invalidInput() {
		while (!(promptInput.equals("pick")) && !(promptInput.equals("plant")) && !(promptInput.equals("status")) && !(promptInput.equals("quit"))) {
			System.out.println("Invalid Input! You can plant and pick flowers, and you can use status to check the status of your garden");
			 promptInput = gardenUserInput.nextLine();
		}
	}
	
	
	public void inputQuit() {
		if (promptInput.equals("quit")) {
			//goes back to the main portion of the park to allow user to go to different location
		}
	}
	
	public void validPlantOrPick() {
		if (promptInput.equals("plant") || promptInput.equals("pick")) {
			addorPickPrompt();
		}
	}
	
	public String zeroFlowers(String flowerName) {
		while (flowersInGarden.get(flowerName) == 0) {
			return "null";
		}
		return flowerName;
	}

	
	public void addorPickPrompt () {
		String flowerName = getFlowerName();
		if (promptInput.equals("pick")) {
			//flowerName = zeroFlowers(flowerName);
			while (zeroFlowers(flowerName).equals("null")) {
				System.out.println("There are zero flowers! What other flowers would you like to pick?");
				flowerName = gardenUserInput.nextLine();
				flowerName = zeroFlowers(flowerName);
			}
			pickFlower(flowerName);
		}
		else if (promptInput.equals("plant")) {
			addFlower(flowerName);
		}	
	}
	
	public String getFlowerName() {
		System.out.println("What Flower would you like to " + promptInput + "?");
		String flowerName = gardenUserInput.nextLine();
		
		while (existingFlower(flowerName).equals("null")) {
			System.out.println("Invalid Flower name! The valid flower names are: roses, dandalions, sunflowers, marigolds, begonias");
			flowerName = gardenUserInput.nextLine();
			flowerName = existingFlower(flowerName);
		}
		return flowerName;
	}
	
	public String existingFlower(String flowerName) {	
		while (flowersInGarden.getOrDefault(flowerName, null) == null) {
			return "null";
		}
		return flowerName;
	}
	
	
	public void addFlower(String flowerName) {
		int flowerNumber = getFlowerNumber();
		if (flowersInGarden.containsKey(flowerName)) {
			insertFlower(flowerName, flowerNumber);
			startOver();
		}
		
	}
	
	public int insertFlower(String flowerName, int flowerNumber) {
		flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) + flowerNumber);
		return flowersInGarden.get(flowerName);
	}
	
	public void pickFlower(String flowerName) {
		int flowerNumber = getFlowerNumber();
		while (invalidFlowerNumber(flowerName, flowerNumber) == -1) {
			System.out.println("You cannot take more flowers than currently in the garden! Try Again!");
			flowerNumber = invalidFlowerNumber(flowerName, flowerNumber);
		}
		
		if (flowersInGarden.containsKey(flowerName)) {
			updatedPickFlower(flowerName, flowerNumber);
			startOver();
		}
	}
	
	public int updatedPickFlower(String flowerName, int flowerNumber) {
		flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) - flowerNumber);
		return flowersInGarden.get(flowerName);
	}
	
	
	public int invalidFlowerNumber(String flowerName, int flowerNumber) {
		while (flowersInGarden.get(flowerName) < flowerNumber) {
			return -1;
		}
		return flowerNumber;
	}
	
	
	public int getFlowerNumber() {
		System.out.println("How many Flowers would you like to " + promptInput + "?");
		int flowerNumber = checkValidInteger(); 
		 
		while (checkNegativeInteger(flowerNumber) == -1) {
			System.out.println("Please type in a valid integer");
			flowerNumber = gardenUserInput.nextInt();
			gardenUserInput.nextLine();
			flowerNumber = checkNegativeInteger(flowerNumber);
		}
		return flowerNumber;
	}
	
	
	public int checkValidInteger() {
		int flowerNumber = 0;
		while (!gardenUserInput.hasNextInt()) {
			System.out.println("Please type in a valid integer");
			gardenUserInput.nextLine();
		}
		flowerNumber = gardenUserInput.nextInt();
		gardenUserInput.nextLine();
		return flowerNumber;
	}
	
	public int checkNegativeInteger (int flowerNumber) {
		while (flowerNumber < 0) {
			return -1;
		}
		return flowerNumber;
	}
	
	public void startOver () {
		printFlowerHashMap();
		promptGarden();	
	}
	

	public void printFlowerHashMap() {
		System.out.println(flowersInGarden + "\n");
		
	}

}
