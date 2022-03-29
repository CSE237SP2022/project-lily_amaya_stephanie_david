package parkSimulator;

import java.util.Scanner;

public class Simulator {

	

	public static void main(String[] args) {
		Park myPark = new Park("Cool Park");
		while(true){
		String locationInputString = myPark.prompt(); //this does not work right now. We should move the non-static methods to the Park class
		myPark.getUserLocation(locationInputString);
		}
	}



	
}
