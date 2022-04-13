package ParkSimulatorTestSuite;


import static org.junit.Assert.*;

import java.util.Arrays;

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
	

	
}
