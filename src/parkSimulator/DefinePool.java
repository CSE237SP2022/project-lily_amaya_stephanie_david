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
		fetchRingGame();
		prompt();
	}
	
	public void swim(){
		setANSIColor(6);
		swimHelper();
		System.out.println("Great job!");
		pause(500);
		prompt();
	}
	
	public void swimHelper() {
		int swimmerLocation=0;
		boolean forwards =true;
		char[] wave = new char[10];
		
		for (int i=0;i<50;i++) {
			printWave(wave,swimmerLocation,i);
			swimmerLocation=updateSwimmerLocation(swimmerLocation,forwards);
			if (swimmerAtBounds(swimmerLocation)) {
				forwards = !forwards;
			}
			
		}
	}
	
	public void waveGenerator(char[]waves,int location) {
		for (int j=0;j<waves.length;j++) {
			waves[j]='w';
		}
		waves[location] = '0';
	}
	
	public void printWave(char[]waves,int location, int waveNumber) {
		System.out.println(String.valueOf(waves) + "         " + swimmerMessage(waveNumber));
		pause(100);
		waveGenerator(waves,location);
	}
	
	public int updateSwimmerLocation(int currentLocation,boolean forward) {
		if (forward) {
			return currentLocation + 1;
		}
		else {
			return currentLocation - 1;	
		}
	}
	
	public boolean swimmerAtBounds(int location) {
		if (location==0 || location==9)
			return true;
		else
			return false;
	}
	
	
	public String swimmerMessage(int location) {
		if (location==10)
			return "Faster!";
		if (location==25)
			return "You got this!";
		if (location==40)
			return "Almost there!";
		else
			return "";
	}
	
	public void fetchRingGame() {
		int score=-1;
		long millis=System.currentTimeMillis(); 
		String currentTrial="";
		while(System.currentTimeMillis() - millis < 2000) {
			score++;
			millis=System.currentTimeMillis();  
			currentTrial=ringFetchGenerator();
			System.out.println(currentTrial);
			if(!ringFetchVerify(currentTrial,poolUserInput.nextInt()))
			break;
		}
		System.out.println("Game over! Your score was " + score + " points.");
	}
	
	public void setANSIColor(int i) {
//		if (ansiEnabled)
//		switch(i) {
//		case 0,1,2,3,4,5,6:
//			System.out.print("\u001B[3" + i +"m"); 
//			break;
//		default:
//			System.out.print("\u001B[37m");
//			break;
//		}
	}
	
	public String ringFetchGenerator() {
		char[] rings = new char[10];
		for (int i=0; i < rings.length;i++) {
			rings[i] = 'W';
		}
		rings[(int)(Math.random()*10)]='0';
		return String.copyValueOf(rings);
	}
	
	public boolean ringFetchVerify(String s, int input) {
		if (s.charAt(input-1)=='0')
			return true;
		else
			return false;
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


