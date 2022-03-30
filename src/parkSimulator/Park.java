package parkSimulator;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class Park {
	private String parkName;
	private List<Location> parkLocations = new ArrayList<Location>();
	private Scanner locationInputScanner = new Scanner(System.in);
	String message;
	
	/**
	 * Constructor for a Park Location
	 * @param name The location/park name
	 */
	public Park(String name) {
		this.parkName = name;
		message = "Welcome to the park! Where would you like to go?";
	}
	
	/**
	 * Returns the name of a park location
	 * @return a string containing the park name
	 */
	public String getParkName() {
		return this.parkName;
	}
	
	/**
	 * Returns the number of sublocations contained in the park location
	 * @return an integer representing number of locations within park
	 */
	public int getLocationCount() {
		return this.parkLocations.size();
	}
	
	/**
	 * Adds a new sublocation to a park location
	 */
	public void addLocation(Location newLocation) {
		this.parkLocations.add(newLocation);
	}
	
	/**
	 * Print all of the locations contained within a park
	 */
	public void printLocations() {
		for (int i=0;i<parkLocations.size();i++) {
			System.out.println(parkLocations.get(i).getLocationName());
		
		}
	}
	
	/**
	 * Prompt user for input regarding where they would like to travel to
	 * @return a string containing the user's input
	 */
	public String prompt() {
		System.out.println(message + " Options are: garden, petting zoo, basketball court, pool");
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;
	}
	
	
	/**
	 * Create and simulate a sublocation
	 * @param locationInputString The location the user wishes to travel to
	 * @return a String providing further instruction to the user
	 */
	public String getUserLocation(String locationInputString) {
			if(locationInputString.equals("garden")) {
				DefineGarden garden = new DefineGarden("garden");
				garden.gardenSimulator();
				message = "Where would you like to go next?";

			}
			else if(locationInputString.equals("petting zoo")) {
				DefinePettingZoo pettingZoo = new DefinePettingZoo("Stephanie's Petting Zoo");
				pettingZoo.pettingZooSimulator();
				message = "Where would you like to go next?";

			}
			else if(locationInputString.equals("basketball court")) {
				DefineBasketballCourt basketballCourt = new DefineBasketballCourt("basketball court");
				basketballCourt.basketballCourtSimulator();
				message = "Where would you like to go next??";

			}
			else if(locationInputString.equals("pool")) {
				DefinePool pool = new DefinePool("Pool", 6, 10);
				pool.poolSimulator();
				message = "Where would you like to go next?";
			}
			else if(locationInputString.equals("leave")) {
				message = "leave";
			}
			else {
				message = "Invalid location. Please enter a valid location.";

			}
			return message;

		
	}
}
