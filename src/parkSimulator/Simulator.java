package parkSimulator;

import java.util.Scanner;

public class Simulator {

	

	public static void main(String[] args) {
		Park myPark = new Park("Cool Park");
		String command = "";
		while(!command.equals("leave")){
		String locationInputString = myPark.prompt(); 
		command = myPark.getUserLocation(locationInputString);
		}
	}



	
}
