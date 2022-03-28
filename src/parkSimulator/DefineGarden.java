package parkSimulator;
import java.util.HashMap;

public class DefineGarden extends Location {
	
	private String gardenName;
	private int numberOfFlowersInHashmap;
	HashMap<String,Integer> flowersInGarden;
	Scanner userInput; // create a scanner
	
	public DefineGarden(String name) {
		super(name);
		gardenName = " ";
		numberOfFlowersInHashmap = 0;
		HashMap<String,Integer> flowersInGarden = new HashMap<String, Integer>();
		
	}
	
	
	public void gardenSimulator() {
		System.out.println("Welcome to the " + gardenName + "! You can plant, pick, and water plants! You can also check the status of your garden using status");
		//prompt user
		exitGarden();//pass into exit method
	}
	

	public void initializeHashmap() {
		flowersInGarden.put("Roses", 4);
		flowersInGarden.put("Dandalions", 6);
		flowersInGarden.put("Sunflowers", 10);
		flowersInGarden.put("Marigolds", 3);
		flowersInGarden.put("Begonias", 3);
	}
	
	public void printflowerHashMap () {
	    System.out.println(flowersInGarden);
	}
	
	public void exitGarden () {
		String inputUser = userInputScanner.nextLine();
		if (inputUser.equals("exit")) {
			returnToParkEntrance();
		}
	}
	
}
