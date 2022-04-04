package parkSimulator;

import java.util.Scanner;

public class DefinePool extends Location{
	
	private double minPoolDepth; //Depth of shallowest part of pool in feet
	private double maxPoolDepth; //Depth of deepest part of pool in feet
	private Scanner poolUserInput; //Scanner for user input
	private int currentActivity; //Track what the user is doing
	
	
	/**
	 * Constructor for a Pool Location
	 * @param name The location/pool name
	 * @param minDepth The minimum depth of the pool in feet
	 * @oaram maxDepth The maximum depth of the pool in feet
	 * @return a DefinePool object representing a pool
	 */
	public DefinePool(String name, double minDepth, double maxDepth) {
		//use super to define location name
		super(name); 
		//initialize variables
		this.minPoolDepth = minDepth;
		this.maxPoolDepth = maxDepth;
		this.poolUserInput = new Scanner(System.in);
		this.currentActivity=0;
	}
	
	public DefinePool(String name) {
		super(name);
		this.minPoolDepth = 1.0;
		this.maxPoolDepth = 4.0;
		this.poolUserInput = new Scanner(System.in);
		this.currentActivity=0;
	}
	
	/**
	 * Return the minimum depth of the pool in feet.
	 * @return double representing the minimum depth of the pool.
	 */
	public double getMinDepth() {
		return this.minPoolDepth;
	}
	
	/**
	 * Return the maximum depth of the pool in feet.
	 * @return double representing the maximum depth of the pool.
	 */
	public double getMaxDepth() {
		return this.maxPoolDepth;
	}
	
	/**
	 * Return the number of the activity the user is currently doing.
	 * @return the number of the activity.
	 */
	public int getCurrentActivityNumber() {
		return this.currentActivity;
	}
	
	/**
	 * Begin the pool simulation.
	 */
	public void poolSimulator() {
		System.out.println("Welcome to the " + this.getLocationName() + "!");
		prompt();
	}
	
	/**
	 * Prompt user to complete an activity.
	 */
	public void prompt() {
		System.out.println("\nActivities are listed below.");
		System.out.println("1. Dive");
		System.out.println("2. Fetch Rings");
		System.out.println("3. Swim");
		System.out.println("4. View Pool Info");
		System.out.println("5. Leave pool");
		System.out.println("\nWhat would you like to do? (Enter 1-5)");
		this.currentActivity = poolUserInput.nextInt();
		switchHandler(this.currentActivity);
	}
	
	public void switchHandler(int i) {
		switch(i) {
		case 1:
			dive();
			break;
		case 2:
			fetchRings();
			break;
		case 3:
			swim();
			break;
		case 4:
			viewPoolInfo();
			break;
		case 5:
			leavePool();
		}
	}
	
	public void dive() {
		System.out.println("Simulate Dive");
		prompt();
	}
	
	public void fetchRings() {
		System.out.println("Simulate fetching rings");
		prompt();
	}
	
	public void swim() {
		System.out.println("Simulate swim");
		prompt();
	}
	
	
	public void viewPoolInfo() {
		System.out.println(this.getLocationName() + " has a minimum depth of " + this.getMinDepth() + " meters and a maximum depth of " + this.getMaxDepth() + " meters.");
		prompt();
		
	}
	
	public void leavePool() {
		System.out.println("Thanks for visiting!");
	}

	}


