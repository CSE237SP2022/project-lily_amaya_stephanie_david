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
		System.out.println("Activities are listed below.");
		System.out.println("1. Dive");
		System.out.println("2. Fetch Rings");
		System.out.println("3. Swim");
		System.out.println("4. View Pool Info");
		System.out.println("\nWhat would you like to do? (Enter 1-4)");
		this.currentActivity = poolUserInput.nextInt();
	}

	}


