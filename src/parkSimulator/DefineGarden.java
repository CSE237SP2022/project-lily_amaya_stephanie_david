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
		gardenName = "Botanical Gardens";
		Scanner gardenUserInput = new Scanner(System.in);
		numberOfFlowersInHashmap = 0;
		HashMap<String,Integer> flowersInGarden = new HashMap<String, Integer>();
		
	}
	
	public void gardenSimulator() {
		System.out.println("Welcome to the " + gardenName + "!");
		initializeHashmap();
		prompt();
		exitGarden();
	}
	//option of adding a condition to the flowers where watering and fertilizing them increases the condition
	
	public void prompt() {
		System.out.println("You can plant and pick flowers! You can check the status of your garden typing status and exit back the main menu by typing exit");
		System.out.println("What would you like to do?");
	}
	
	
	public void initializeHashmap() {
		flowersInGarden.put("Roses", 4);
		flowersInGarden.put("Dandalions", 6);
		flowersInGarden.put("Sunflowers", 10);
		flowersInGarden.put("Marigolds", 3);
		flowersInGarden.put("Begonias", 8);
	}
	
	public void printflowerHashMap () {
	    System.out.println(flowersInGarden);
	}
	
	public void exitGarden () {
		String inputUser = gardenUserInput.nextLine();
		if (inputUser.equals("exit")) {
			returnToParkEntrance();
		}
	}
}
