package parkSimulator;

import java.util.Scanner;

public class Simulator {

	
	/**
	 * Execute a simulation of a park
	 */
	public static void main(String[] args) {
		Park myPark = new Park("Cool Park");
		String command = "";
		while(!command.equals("leave")){
		String locationInputString = myPark.prompt(); 
		command = myPark.getUserLocation(locationInputString);
		}
	}



	
}
