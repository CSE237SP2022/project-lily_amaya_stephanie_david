package parkSimulator;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class Park {
	private String parkName;
	private List<Location> parkLocations = new ArrayList<Location>();
	private Scanner locationInputScanner = new Scanner(System.in);
	String message;
	
	public Park(String name) {
		this.parkName = name;
		message = "Welcome to the park! Where would you like to go?";
	}
	
	public String getParkName() {
		return this.parkName;
	}
	
	public int getLocationCount() {
		return this.parkLocations.size();
	}
	
	public void addLocation(Location newLocation) {
		this.parkLocations.add(newLocation);
	}
	
	public void printLocations() {
		for (int i=0;i<parkLocations.size();i++) {
			System.out.println(parkLocations.get(i));
		}
	}
	
	public String prompt() {
		System.out.println(message + " Options are: garden, petting zoo, basketball court, pool");
		String locationInputString = locationInputScanner.nextLine();
		return locationInputString;
	}
	
	public void getUserLocation(String locationInputString) {
		
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
				DefinePool pool = new DefinePool("Pool");
				pool.poolSimulator();
				message = "Where would you like to go next?";
			}
			else {
				message = "Invalid location. Please enter a valid location.";
			}
		
	}
}
