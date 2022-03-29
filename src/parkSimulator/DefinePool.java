package parkSimulator;

import java.util.Scanner;

public class DefinePool extends Location{
	
	private String poolName;
	private double minPoolDepth;
	private double maxPoolDepth;
	private Scanner poolUserInput;
	private int currentActivity;
	
	public DefinePool(String name, double minDepth, double maxDepth) {
		super(name);
		this.minPoolDepth = minDepth;
		this.maxPoolDepth = maxDepth;
		this.poolUserInput = new Scanner(System.in);
		this.currentActivity=0;
	}
	
	public void poolSimulator() {
		System.out.println("Welcome to the " + this.poolName + "!");
		prompt();
	}
	
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


