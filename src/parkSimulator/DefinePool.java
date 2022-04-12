package parkSimulator;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DefinePool extends Location{
	
	private double minPoolDepth; //Depth of shallowest part of pool in feet
	private double maxPoolDepth; //Depth of deepest part of pool in feet
	private Scanner poolUserInput; //Scanner for user input
	private int currentActivity; //Track what the user is doing
	private boolean ansiEnabled; //Determine if user terminal supports ANSI for color encoding
	
	
	/**
	 * Constructor for a Pool Location
	 * @param name The location/pool name
	 * @param minDepth The minimum depth of the pool in feet
	 * @oaram maxDepth The maximum depth of the pool in feet
	 */
	public DefinePool(String name, double minDepth, double maxDepth) {
		//use super to define location name
		super(name); 
		//initialize variables
		this.minPoolDepth = minDepth;
		this.maxPoolDepth = maxDepth;
		this.poolUserInput = new Scanner(System.in);
		this.currentActivity=0;
		this.ansiEnabled=true;
	}
	
	public DefinePool(String name) {
		super(name);
		this.minPoolDepth = 1.0;
		this.maxPoolDepth = 4.0;
		this.poolUserInput = new Scanner(System.in);
		this.currentActivity=0;
		this.ansiEnabled=true;
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
		System.out.println("Does your terminal support ANSI? Type yes or no.");
		if (!poolUserInput.nextLine().equals("yes")) {
			this.ansiEnabled=false;
		}
		prompt();
	}
	
	/**
	 * Prompt user to complete an activity.
	 */
	public void prompt() {
		setANSIColor(7);
		System.out.println("\nActivities are listed below.\n1. Dive\n2. Fetch Rings\n3. Swim\n4. View Pool Info\n5. Leave Pool\n\n\nWhat would you like to do? (Enter 1-5)");
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
			break;
		default:
			switchError();
		}
	}
	
	public void switchError() {
		setANSIColor(1);
		System.out.println("Invalid option.");
		prompt();
	}
	
	public void dive() {
		System.out.println("Simulate Dive");
		prompt();
	}
	
	public void fetchRings() {
		System.out.println("\nTo catch rings you'll have to enter which spot the ring is at! (1-10)\nWWWWW0WWWW\nHere, you would type \"6\" and press enter.\n0WWWWWWWWW\nHere, you would type \"1\" and press enter.\nIf you're not fast enough someone else might grab them, so hurry!\n\nPress any button and hit enter to continue.");
		String continuePrompt = poolUserInput.next();
		prompt();
	}
	
	public void swim(){
		setANSIColor(6);
		int swimmerLocation=0;
		boolean forwards =true;
		String message;
		char[] wave = new char[10];
		for (int i=0;i<50;i++) {
			message = "";
			for (int j=0;j<wave.length;j++) {
				wave[j]='w';
			}
			wave[swimmerLocation] = '0';
			if (forwards) {
				swimmerLocation++;
				if (swimmerLocation>9) {
					forwards = false;
					swimmerLocation=9;
				}
			}
			else {
				swimmerLocation--;
				if (swimmerLocation<0) {
					forwards = true;
					swimmerLocation=0;
				}
					
			}
			if (i==10)
			message = "Faster!";
			if (i==25)
				message = "You got this!";
			if (i==40)
				message = "Almost there!";
			System.out.println(String.valueOf(wave) + "         " + message);
			pause(100);
		}
		System.out.println("Great job!");
		pause(500);
		prompt();
	}
	
	public void fetchRingGame() {
		int score=0;
	}
	
	public void setANSIColor(int i) {
		if (ansiEnabled)
		switch(i) {
		case 0,1,2,3,4,5,6:
			System.out.print("\u001B[3" + i +"m"); 
			break;
		default:
			System.out.print("\u001B[37m");
			break;
		}
	}
	
	public String ringFetchGenerator() {
		char[] rings = new char[10];
		for (int i=0; i < rings.length;i++) {
			rings[i] = 'W';
		}
		rings[(int)(Math.random()*10)]='0';
		return String.copyValueOf(rings);
	}
	
	public void pause(int milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void viewPoolInfo() {
		setANSIColor(3);
		System.out.println("****************************************************");
		System.out.println(this.getLocationName() + " has a minimum depth of " + this.getMinDepth() + " meters \nand a maximum depth of " + this.getMaxDepth() + " meters.");
		System.out.println("****************************************************");
		prompt();
		
	}
	
	public void leavePool() {
		System.out.println("Thanks for visiting!");
	}

	}


