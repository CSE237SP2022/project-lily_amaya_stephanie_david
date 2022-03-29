package parkSimulator;
import java.util.HashMap;
import java.util.Scanner;

public class DefineGarden extends Location {
	
	private String gardenName;
	private int numberOfFlowersInHashmap;
	private Scanner gardenUserInput;
	private HashMap<String,Integer> flowersInGarden;
	
	public DefineGarden(String name) {
		super(name);
		this.gardenName = "Botanical Gardens";
		this.gardenUserInput = new Scanner(System.in);
		this.numberOfFlowersInHashmap = 0;
		this.flowersInGarden = new HashMap<String, Integer>() {{
			put("Roses", 4);
			put("Dandalions", 6);
			put("Sunflowers", 10);
			put("Marigolds", 3);
			put("Begonias", 8);
		}};
		
	}
	
	public void gardenSimulator() {
		System.out.println("Welcome to the " + gardenName + "!");
		promptGarden();
		printFlowerHashMap();
	}
	//option of adding a condition to the flowers where watering and fertilizing them increases the condition
	
	public void promptGarden() {
		System.out.println("You can plant and pick flowers, and you can use status to check the status of your garden");
		System.out.println("What would you like to do?");
		String promptInput = gardenUserInput.nextLine();
	}
	
	

	public void printFlowerHashMap () {
	    System.out.println(flowersInGarden);
	}

}
