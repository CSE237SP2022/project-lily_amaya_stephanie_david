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
		welcomePrompt();
		inputPlantOrPick();
		inputQuit();
		invalidInput();
		inputStatus();
	}
	
	
	public void welcomePrompt() {
		System.out.println("You can type plant, pick, status or quit to plant/pick flowers, check the status of the garden or go to a different location");
		System.out.println("What would you like to do?");
		promptInput = gardenUserInput.nextLine();
	}
	
	public void inputPlantOrPick() {
		if (promptInput.equals("plant") || promptInput.equals("pick")) {
			addorPickPrompt();
		}
	}
	
	public void addorPickPrompt () {
		String flowerName = getFlowerName(); 
		
		if (promptInput.equals("pick")) {
			checkIfZeroFlowers(flowerName);
			pickFlower(flowerName);
		}
		else if (promptInput.equals("plant")) {
			addFlower(flowerName);
		}	
	}

	
	public String getFlowerName() {
		System.out.println("What flower would you like to " + promptInput + "?");
		String flowerName = gardenUserInput.nextLine();
		flowerName = checkIfExistingFlower(flowerName);
		return flowerName;
	}


	private String checkIfExistingFlower(String flowerName) {
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
	
	private void checkIfZeroFlowers(String flowerName) {
		while (zeroFlowers(flowerName).equals("null")) {
			System.out.println("There are zero flowers! What other flowers would you like to pick?");
			flowerName = gardenUserInput.nextLine();
			flowerName = zeroFlowers(flowerName);
		}
	}
	
	public String zeroFlowers(String flowerName) {
		while (flowersInGarden.get(flowerName) == 0) {
			return "null";
		}
		return flowerName;
	}
	
	public void pickFlower(String flowerName) {
		int flowerNumber = getFlowerNumber();
		flowerNumber = checkIfInvalidNumberInput(flowerName, flowerNumber);
		extractFlowers(flowerName, flowerNumber);
		startOver();
	}


	private int checkIfInvalidNumberInput(String flowerName, int flowerNumber) {
		while (invalidFlowerNumber(flowerName, flowerNumber) == -1) {
			System.out.println("You cannot take more flowers than currently in the garden! Try Again!");
			flowerNumber = invalidFlowerNumber(flowerName, flowerNumber);
		}
		return flowerNumber;
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
	
	
	public void addFlower(String flowerName) {
		int flowerNumber = getFlowerNumber();
		insertFlower(flowerName, flowerNumber);
		startOver();
		
	}
	
	public int insertFlower(String flowerName, int flowerNumber) {
		flowersInGarden.put(flowerName, flowersInGarden.get(flowerName) + flowerNumber);
		return flowersInGarden.get(flowerName);
	}
	
	
	public int extractFlowers(String flowerName, int flowerNumber) {
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
		System.out.println("How many flowers would you like to " + promptInput + "?" + " (Input Integers only)");
		
		int flowerNumber = gardenUserInput.nextInt();
		gardenUserInput.nextLine();
		flowerNumber = checkNegativeInput(flowerNumber);
		return flowerNumber;
	}


	private int checkNegativeInput(int flowerNumber) {
		while (negativeInteger(flowerNumber) == -1) {
			System.out.println("Please type in a valid integer");
			flowerNumber = gardenUserInput.nextInt();
			gardenUserInput.nextLine();
			flowerNumber = negativeInteger(flowerNumber);
		}
		return flowerNumber;
	}
	
	
	public int negativeInteger (int flowerNumber) {
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