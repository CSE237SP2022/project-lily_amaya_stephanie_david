package parkSimulator;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.ComponentOrientation;


public class DefinePool extends Location{
	
	private double minPoolDepth; //Depth of shallowest part of pool in feet
	private double maxPoolDepth; //Depth of deepest part of pool in feet
	private Scanner poolUserInput; //Scanner for user input
	private int currentActivity; //Track what the user is doing
	private boolean ansiEnabled; //Determine if user terminal supports ANSI for color encoding
	private double gameScore;
	private double gameTimer;
	
	
	/**
	 * Constructor for a Pool Location
	 * @param name The location/pool name
	 * @param minDepth The minimum depth of the pool in feet
	 * @param maxDepth The maximum depth of the pool in feet
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
		this.ansiEnabled=true;
	}
	
	/**
	 * Constructor for a Pool Location
	 * @param name The location/pool name
	 * @return a DefinePool object representing a pool
	 */
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
		String[] validResponses = {"yes","no"};
		if (!promptUserString("",validResponses).equals("yes")) {
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
		this.currentActivity = promptUserNum("",1,5);
		switchHandler(this.currentActivity);
	}
	
	/**
	 * Execute the appropriate activity given user input
	 * @param i The integer the user entered.
	 */
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
	
	/**
	 * Print an error if the user chose an invalid activity and reprompt
	 */
	public void switchError() {
		setANSIColor(1);
		System.out.println("Invalid option.");
		prompt();
	}
	
	/**
	 * Execute dive simulation
	 */
	public void dive() {
		JFrame frame = new JFrame("Dive Simulator");
		frame.pack();
		DecimalFormat df = new DecimalFormat("#.##");
	    df.setRoundingMode(RoundingMode.FLOOR);
		frame.setLayout(new GridLayout(3,1));
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(new Color(145, 193, 255));
		frame.setSize(500,500);
		frame.setResizable(false);	
		JLabel diveTitle = new JLabel("Diving Simulator",SwingConstants.CENTER);
		diveTitle.setFont(diveTitle.getFont().deriveFont(48f)); 
		JLabel instructions = new JLabel("Press the run button as fast as you can to get a good jump!",SwingConstants.CENTER);
		instructions.setFont(instructions.getFont().deriveFont(16f)); 
		gameScore=0;
		JLabel scoreText = new JLabel("Speed: " + gameScore + "MPH",SwingConstants.CENTER);
		scoreText.setFont(scoreText.getFont().deriveFont(48f)); 
		JLabel timerText = new JLabel(""+gameTimer,SwingConstants.CENTER);
		timerText.setFont(timerText.getFont().deriveFont(64f)); 
		timerText.setForeground(new Color(150,0,0));
		JButton playButton = new JButton("Play");
		JButton startButton = new JButton("Start"); 
		JButton runButton = new JButton("Run!");
		JButton exitButton = new JButton("Exit");
		JLabel gameOverText = new JLabel("Game Over! Your final speed was " + gameScore + " mph, you jumped " + df.format(0.47*gameScore) +" feet in the air!",SwingConstants.CENTER) ;
		gameTimer = 10;
		exitButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					frame.dispose();
			        }  
			    });  
		
		playButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            frame.getContentPane().removeAll();
			            //add new components
			            frame.add(instructions);
			            frame.add(startButton);
			            frame.validate(); // ensure they are drawn
			            frame.repaint();
			        }  
			    }); 
		startButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            frame.getContentPane().removeAll();
			            gameTimer=10;
			            gameScore=0;
			            scoreText.setText("Speed: " + df.format(gameScore) + "MPH");
			            //add new components
			            frame.add(scoreText);
			            frame.add(timerText);
			            frame.add(runButton);
			            frame.validate(); // ensure they are drawn
			            frame.repaint();
			            new java.util.Timer().scheduleAtFixedRate(new TimerTask(){
			                @Override
			                public void run() {
			                	if (gameTimer<=0.11) {
			                		exitButton.setEnabled(false);
			                		frame.getContentPane().removeAll();
			                		gameOverText.setText("Game Over! Your final speed was " + df.format(gameScore) + " mph, you jumped " + df.format(0.47*gameScore) +" feet in the air!");
			                		frame.add(gameOverText);
			                		startButton.setText("Play again");
			                		frame.add(startButton);
			                		frame.add(exitButton);
			                		frame.validate();
			                		frame.repaint();
			                		new java.util.Timer().schedule(new TimerTask(){
						                @Override
						                public void run() {
						                	exitButton.setEnabled(true);
						                }
						            },3000,3000); 
			                		cancel(); 		
			                	}
			                	timerText.setText(df.format(gameTimer));
			                    gameTimer-=0.1;
			                }
			            },100,100); 
			        }  
			    }); 
		runButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            gameScore+=0.10;
			            //add new components
			            scoreText.setText("Speed: " + df.format(gameScore) + "MPH");
			        }  
			    }); 
		
		frame.add(diveTitle);
		frame.add(playButton);
		frame.add(exitButton);
		frame.setVisible(true);
		prompt();
	}
	
	/**
	 * Execute ring fetch simulation
	 */
	public void fetchRings() {
		System.out.println("\nTo catch rings you'll have to enter which spot the ring is at! (1-10)\nWWWWW0WWWW\nHere, you would type \"6\" and press enter.\n0WWWWWWWWW\nHere, you would type \"1\" and press enter.\nIf you're not fast enough someone else might grab them, so hurry!\n\nPress any button and hit enter to continue.");
		promptUserAny();
		fetchRingGame();
		prompt();
	}
	
	/**
	 * Execute swim simulation
	 */
	public void swim(){
		setANSIColor(6);
		swimHelper();
		System.out.println("Great job!");
		pause(500);
		prompt();
	}
	
	/**
	 * Chain swim methods together to execute simulation correctly
	 */
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
	
	/**
	 * Setup a char array to simulate a wave with a swimmer
	 * @param waves An array of chars
	 * @param location The location of the swimmer in a wave
	 */
	public void waveGenerator(char[]waves,int location) {
		for (int j=0;j<waves.length;j++) {
			waves[j]='w';
		}
		waves[location] = '0';
	}
	
	/**
	 * Print the swim simulation data
	 * @param waves An array of chars already setup to represent a wave
	 * @param location The location of the swimmer in a wave
	 * @param waveNumber Which wave you're running
	 */
	public void printWave(char[]waves,int location, int waveNumber) {
		System.out.println(String.valueOf(waves) + "         " + swimmerMessage(waveNumber));
		pause(100);
		waveGenerator(waves,location);
	}
	
	/**
	 * Update the swimmer's location in a wave
	 * @param currentLocation The location of the swimmer in the wave
	 * @param forward True if swimmer is going right, False if going left
	 * @return an Integer with the next swimmer location
	 */
	public int updateSwimmerLocation(int currentLocation,boolean forward) {
		if (forward) {
			return currentLocation + 1;
		}
		else {
			return currentLocation - 1;	
		}
	}
	
	/**
	 * Determine if the swimmer is at the edge of a wave
	 * @param location The location of the swimmer in the wave
	 * @return True if the swimmer is at edge of wave, false if not
	 */
	public boolean swimmerAtBounds(int location) {
		if (location==0 || location==9)
			return true;
		else
			return false;
	}
	
	/**
	 * Determine if additional message needed for current wave of swim simulation
	 * @param location The current wave
	 * @return A string containing an additional message if needed
	 */
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
	
	/**
	 * Execute the ring fetch minigame
	 */
	public void fetchRingGame() {
		int score=-1;
		long millis=System.currentTimeMillis(); 
		String currentTrial="";
		String endCause="Too Slow! ";
		while(System.currentTimeMillis() - millis < 2000) {
			score++;
			millis=System.currentTimeMillis();  
			currentTrial=ringFetchGenerator();
			System.out.println(currentTrial);
			if(!ringFetchVerify(currentTrial,promptUserNum("",1,10))) {
			    endCause = "You missed! ";
				break;
			}
		}
		System.out.println(endCause + " Your score was " + score + " points.");
	}
	
	/**
	 * Print ANSI data to change text color in terminal
	 * @param i The ANSI number to set the text color to, defaults to white if invalid.
	 */
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
	
	/**
	 * Generate a random wave with a ring for the ring fetch mini game
	 * @return a String of length 10 made of all 'W's and one ring, '0'
	 */
	public String ringFetchGenerator() {
		char[] rings = new char[10];
		for (int i=0; i < rings.length;i++) {
			rings[i] = 'W';
		}
		rings[(int)(Math.random()*10)]='0';
		return String.copyValueOf(rings);
	}
	
	/**
	 * Determine if the user input was correct for the ring fetch mini game
	 * @param s The current string/wave of the game
	 * @param input The location the user gave
	 * @return boolean true if user answered correctly, false if not
	 */
	public boolean ringFetchVerify(String s, int input) {
		if (s.charAt(input-1)=='0')
			return true;
		else
			return false;
	}
	
	/**
	 * Temporarily sleep, pausing program execution
	 * @param milliseconds The time period to pause for in milliseconds
	 */
	public void pause(int milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Print a pool location's data
	 */
	public void viewPoolInfo() {
		setANSIColor(3);
		System.out.println("****************************************************");
		System.out.println(this.getLocationName() + " has a minimum depth of " + this.getMinDepth() + " meters \nand a maximum depth of " + this.getMaxDepth() + " meters.");
		System.out.println("****************************************************");
		prompt();
		
	}
	
	public int promptUserNum(String message, int low, int high) {
		System.out.print(message);
		while(!poolUserInput.hasNextInt()) {
			System.out.println("Not a number, try again.");
			poolUserInput.next();
		}
		int input = poolUserInput.nextInt();
		while (input>high || input<low) {
			System.out.println("Invalid number. Try again.");
			input = poolUserInput.nextInt();
		}
		return input;
	}
	
	public void promptUserAny() {
		String blank=poolUserInput.next();
	}
	
	public String promptUserString(String message,String[]validInput) {
		System.out.print(message);
		String input;
		while (true) {
		input = poolUserInput.nextLine();
		for (int i=0; i < validInput.length;i++) {
			if (validInput[i].equalsIgnoreCase(input))
				return input;
		}
		System.out.println("Invalid input, try again.");
		}
	}
	
	/**
	 * Print exit message
	 */
	public void leavePool() {
		System.out.println("Thanks for visiting!");
	}

	}


