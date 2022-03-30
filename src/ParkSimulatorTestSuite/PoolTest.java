package ParkSimulatorTestSuite;


import static org.junit.Assert.*;

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
	public void testInputRegistered() {
		DefinePool testPool = new DefinePool("Splash Zone Pool",1.0,9.0);
		System.out.println("Input an integer.");
		testPool.prompt();
		assertFalse(testPool.getCurrentActivityNumber==0);
	}
	
	
	

	
	
	
	
	
	
	
}
