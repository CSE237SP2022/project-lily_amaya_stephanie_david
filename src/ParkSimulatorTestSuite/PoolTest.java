package ParkSimulatorTestSuite;


import static org.junit.Assert.*;

import java.awt.Component;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.Test;


import parkSimulator.DefinePool;



public class PoolTest {

	@Test
	public void testPoolName() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		String poolName = testPool.getLocationName();
		assertTrue(poolName.equals("Splash Zone Pool"));
	}
	
	@Test
	public void testPoolMinDepth() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		double depth = testPool.getMinDepth();
		assertEquals(1.0,depth,0.1);
	}
	
	@Test
	public void testPoolMaxDepth() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		double depth = testPool.getMaxDepth();
		assertEquals(9.0,depth,0.1);
	}
	
	@Test
	public void testGetCurrentActivityNumber() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		assertEquals(0,testPool.getCurrentActivityNumber());
	}
	
	@Test
	public void testWaveGenerator() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		char[]sample=new char[7];
		testPool.waveGenerator(sample,6);
		char[]correct= {'w','w','w','w','w','w','0'};
		assertTrue(Arrays.equals(sample,correct));
	}
	
	@Test
	public void testUpdateSwimmerLocation() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		int t1 = testPool.updateSwimmerLocation(2, false);
		int t2 = testPool.updateSwimmerLocation(6, true);
		int t3 = testPool.updateSwimmerLocation(0, true);
		assertEquals(1,t1);
		assertEquals(7,t2);
		assertEquals(1,t3);
	}
	
	@Test
	public void testSwimmerAtBounds() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		boolean t1 = testPool.swimmerAtBounds(0);
		boolean t2 = testPool.swimmerAtBounds(9);
		boolean t3 = testPool.swimmerAtBounds(4);
		assertTrue(t1);
		assertTrue(t2);
		assertFalse(t3);
	}
	
	@Test
	public void testSwimmerMessage() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		String s1 = testPool.swimmerMessage(0);
		String s2 = testPool.swimmerMessage(10);
		String s3 = testPool.swimmerMessage(25);
		String s4 = testPool.swimmerMessage(40);
		assertTrue(s1.equals(""));
		assertTrue(s2.equals("Faster!"));
		assertTrue(s3.equals("You got this!"));
		assertTrue(s4.equals("Almost there!"));
	}
	
	@Test
	public void testRingFetchGenerator() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		int waterCount=0;
		int ringCount=0;
		String randomWave=testPool.ringFetchGenerator();
		for (int i=0;i < randomWave.length();i++) {
			if (randomWave.charAt(i)=='W')
				waterCount++;
			if (randomWave.charAt(i)=='0')
				ringCount++;
		}
		assertEquals(1,ringCount);
		assertEquals(9,waterCount);
	}
	
	@Test
	public void testRingFetchVerify() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		assertTrue(testPool.ringFetchVerify("WWWW0",5));
		assertFalse(testPool.ringFetchVerify("W0WWW",3));
	}
	
	@Test
	public void testPause() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		long before = System.currentTimeMillis();
		testPool.pause(1000);
		long after = System.currentTimeMillis();
		long difference = after - before;
		assertTrue(difference>999 && difference<1100);
	}
	
	@Test
	public void testResetDiveGame() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		Component[] testComponents = new Component[9];
		testComponents[7] = new JLabel("Test");
		testPool.setGameScore(90);
		testPool.setGameScore(90);
		testPool.resetDiveGame(testComponents);
		assertEquals(0,testPool.getGameScore(),0.5);
		assertEquals(10,testPool.getGameTimer(),0.5);
	}
	
	@Test
	public void testPerformRun() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		Component[] testComponents = new Component[9];
		testComponents[7] = new JLabel("Test");
		testPool.resetDiveGame(testComponents);
		testPool.performRun(testComponents);
        JLabel scoreText = (JLabel) testComponents[7];
		assertEquals(0.1,testPool.getGameScore(),0.01);
		assertTrue(scoreText.getText().contains("Speed: 0.1MPH") || scoreText.getText().contains("Speed: 0.09MPH"));
	}
	
	@Test
	public void testDecrementTimer() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		Component[] testComponents = new Component[9];
		testComponents[8] = new JLabel("Test");
		testPool.setGameTimer(1.0);
		testPool.decrementTimer(testComponents);
		JLabel timerLabel = (JLabel)testComponents[8];
		assertTrue(timerLabel.getText().equals("1"));
		assertEquals(0.9,testPool.getGameTimer(),0.05);
		testPool.decrementTimer(testComponents);
		assertTrue(timerLabel.getText().contains("0.9"));
		assertEquals(0.8,testPool.getGameTimer(),0.05);
	}
	
	@Test
	public void testPrepareGameOverComponents() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		Component[] testComponents = new Component[9];
		testComponents[1] = new JButton("A");
		testComponents[6] = new JLabel("B");
		testPool.prepareGameOverComponents(testComponents);
		testPool.setGameScore(0.0);
		JLabel gameOverText = (JLabel)testComponents[6];
		JButton startButton = (JButton)testComponents[1];
		assertTrue(gameOverText.getText().equals("Game Over! Your final speed was 0 mph, you jumped 0 feet in the air!"));
		assertTrue(startButton.getText().equals("Play again"));
	}
	

	
}
