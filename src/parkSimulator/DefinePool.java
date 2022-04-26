package parkSimulator;

import java.awt.FlowLayout;
import java.awt.Frame;
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
import java.awt.Component;
import java.awt.ComponentOrientation;


public class DefinePool extends Location{
	
	private double minPoolDepth; //Depth of shallowest part of pool in feet
	private double maxPoolDepth; //Depth of deepest part of pool in feet
	private Scanner poolUserInput; //Scanner for user input
	private int currentActivity; //Track what the user is doing
	private double gameScore;
	private double gameTimer;
	private JFrame frame = new JFrame("Dive Simulator");
	private DecimalFormat df = new DecimalFormat("#.##");
	
	
	
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
		this.gameScore=0;
		this.gameTimer=10;
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
		this.gameScore=0;
		this.gameTimer=10;
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
	
	public double getGameScore() {
		return this.gameScore;
	}
	
	public double getGameTimer() {
		return this.gameTimer;
	}
	
	public void setGameScore(double score) {
		this.gameScore = score;
	}
	
	public void setGameTimer(double time) {
		this.gameTimer = time;
	}
	
	
	/**
	 * Begin the pool simulation.
	 */
	public void poolSimulator() {
	    df.setRoundingMode(RoundingMode.FLOOR);
		System.out.println("Welcome to the " + this.getLocationName() + "!");
		prompt();
	}
	
	/**
	 * Prompt user to complete an activity.
	 */
	public void prompt() {
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
			checkWindows();
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
		System.out.println("Invalid option.");
		prompt();
	}
	
	/**
	 * Execute dive simulation
	 */
	public void dive() {
		frame.pack();
		gameTimer = 10;
		assembleFrame();
		Component[] frameComponents = new Component[9];	
		initializeComponents(frameComponents);
		assembleTitleScreen(frameComponents);
		frame.setVisible(true); 
		prompt();
	}
	
	public void initializeComponents(Component[] frameComponents) {
		initializeTitleComponents(frameComponents);
		initializeInstructionComponents(frameComponents);
		initializePlayComponents(frameComponents);
	}
	
	public void initializeTitleComponents(Component[] frameComponents) {
		frameComponents[0] = new JLabel("Diving Simulator",SwingConstants.CENTER);
		frameComponents[0].setFont(frameComponents[0].getFont().deriveFont(48f)); 
		frameComponents[1]= new JButton("Play");
		frameComponents[2]= new JButton("Exit");
	}
	
	public void initializeInstructionComponents(Component[] frameComponents) {
		frameComponents[3] = new JLabel("Press the run button as fast as you can to get a good jump!",SwingConstants.CENTER);
		frameComponents[3].setFont(frameComponents[3].getFont().deriveFont(16f)); 
		frameComponents[4] = new JButton("Start"); 
		frameComponents[6] = new JLabel("Game Over! Your final speed was " + gameScore + " mph, you jumped " + df.format(0.47*gameScore) +" feet in the air!",SwingConstants.CENTER) ;
	}
	
	public void initializePlayComponents(Component[] frameComponents) {
		frameComponents[5]= new JButton("Run!");
		frameComponents[7] = new JLabel("Speed: " + gameScore + "MPH",SwingConstants.CENTER);
		frameComponents[8]= new JLabel(""+gameTimer,SwingConstants.CENTER);
		frameComponents[7].setFont(frameComponents[7].getFont().deriveFont(48f)); 
		frameComponents[8].setForeground(new Color(150,0,0));
		frameComponents[8].setFont(frameComponents[7].getFont().deriveFont(64f)); 
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
	

	
	public void checkWindows() {
		System.out.println("Are you using Windows Subsystem for Linux? Type yes or no.");
		String[] validResponses = {"yes","no"};
		if (!promptUserString("",validResponses).equals("yes")) {
			System.out.println("Starting! It may be minimized :)");
			dive();
		}
		else {
			System.out.println("Sorry, the dive minigame doesn't support WSL.");
			prompt();
		}
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
		input = poolUserInput.next();
		for (int i=0; i < validInput.length;i++) {
			if (validInput[i].equalsIgnoreCase(input))
				return input;
		}
		System.out.println("Invalid input, try again.");
		}
	}
	
	public void assembleFrame() {
		frame.setLayout(new GridLayout(3,1));
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(new Color(145, 193, 255));
		frame.setSize(500,500);
		frame.setResizable(false);	
	}
	
	public void assembleTitleScreen(Component[] frameComponents) {
		frame.getContentPane().removeAll();
		setTitleButtons(frameComponents);
		frame.add(frameComponents[0]);
		frame.add(frameComponents[1]);
		frame.add(frameComponents[2]);
		makeFrameValid();
	}
	
	public void setTitleButtons(Component[]frameComponents) {
		JButton exitButton = (JButton)frameComponents[2];
		exitButton.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){  frame.dispose(); }}); 
		JButton playButton = (JButton)frameComponents[1];
		playButton.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){ assembleInstructionScreen(frameComponents); }}); 
	}
	
	public void assembleInstructionScreen(Component[] frameComponents) {
		frame.getContentPane().removeAll();
		frame.add(frameComponents[3]);
        frame.add(frameComponents[4]);
        JButton startButton = (JButton)frameComponents[4];
 		startButton.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){ assemblePlayScreen(frameComponents); }}); 
		makeFrameValid();
	}
	
	public void scheduleGameTimer(Component[]frameComponents) {
        new java.util.Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
            	if (gameTimer<=0.11) {
            		assembleGameOverScreen(frameComponents);
            		cancel(); 		
            	}
            	decrementTimer(frameComponents);
            }
        },100,100); 
	}
	
	public void decrementTimer(Component[] frameComponents) {
    	JLabel timerText = (JLabel)frameComponents[8];
    	timerText.setText(df.format(gameTimer));
        gameTimer-=0.1;
	}
	
	public void assemblePlayScreen(Component[] frameComponents) {
		 frame.getContentPane().removeAll();
		 preparePlayComponents(frameComponents);
         scheduleGameTimer(frameComponents);
 		 JButton runButton = (JButton)frameComponents[5];
 		 runButton.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){ performRun(frameComponents); }}); 
		 makeFrameValid();
	}
	
	public void preparePlayComponents(Component[] frameComponents) {
        resetDiveGame(frameComponents);
        frame.add(frameComponents[7]);
        frame.add(frameComponents[8]);
        frame.add(frameComponents[5]);
	}
	
	public void resetDiveGame(Component[]frameComponents) {
        gameTimer=10;
        gameScore=0;
        JLabel scoreText = (JLabel) frameComponents[7];
        scoreText.setText("Speed: " + df.format(gameScore) + "MPH");
	}
	
	public void performRun(Component[] frameComponents) {
         gameScore+=0.10;
         JLabel scoreText = (JLabel) frameComponents[7];
         scoreText.setText("Speed: " + df.format(gameScore) + "MPH");
	}
	
	public void assembleGameOverScreen(Component[] frameComponents) {
		frame.getContentPane().removeAll();
 		prepareGameOverComponents(frameComponents);
 		scheduleExitButton(frameComponents);
 		frame.add(frameComponents[2]);
		makeFrameValid();
	}
	
	public void prepareGameOverComponents(Component[] frameComponents) {
		JLabel gameOverText = (JLabel)frameComponents[6];
 		gameOverText.setText("Game Over! Your final speed was " + df.format(gameScore) + " mph, you jumped " + df.format(0.47*gameScore) +" feet in the air!");
 		frame.add(frameComponents[6]);
 		JButton startButton = (JButton)frameComponents[1];
 		startButton.setText("Play again");            		
 		frame.add(startButton);
	}
	
	public void scheduleExitButton(Component[] frameComponents) {
		frameComponents[2].setEnabled(false);
 		new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
            	frameComponents[2].setEnabled(true);
            }
        },3000,3000); 
	}
	
	public void makeFrameValid() {
		frame.validate();
		frame.repaint();
	}
	
	/**
	 * Print exit message
	 */
	public void leavePool() {
		System.out.println("Thanks for visiting!");
	}

	}


