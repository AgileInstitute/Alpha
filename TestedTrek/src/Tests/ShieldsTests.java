package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import StarTrek.Shields;


public class ShieldsTests {
	private Shields shields;
	
	 @Before
	 public void initializeShields() {
		 shields = new Shields();
	 }
	 
	 @Test 
	 public void maxShieldConstant(){
			assertEquals(Shields.MAX_SHIELD_LEVEL, 10000);
	 }
	 
	 @Test 
	 public void minShieldConstant(){
			assertEquals(Shields.MIN_SHIELD_LEVEL, 0);
	 }
	
	@Test
	public void defaultSheildTest() {
		
		assertEquals(Shields.MAX_SHIELD_LEVEL, shields.getLevel());
	}

	@Test
	public void maxShieldsTest(){
		shields.increaseStrengthBy(Shields.MAX_SHIELD_LEVEL + 1);
		assertEquals(Shields.MAX_SHIELD_LEVEL, shields.getLevel());
	}
	
	@Test
	public void reduceShieldPowerTest(){
		shields.increaseStrengthBy(-5);
		assertEquals(9995, shields.getLevel());
	}
	

	@Test
	public void minShieldsTest(){
		shields.increaseStrengthBy(-(Shields.MAX_SHIELD_LEVEL + 1));
		assertEquals(Shields.MIN_SHIELD_LEVEL, shields.getLevel());
	}
	
	@Test
	public void testShieldsUp() {
		shields.raiseShield();
		assertEquals(true, shields.isSheildUp());
	}
	
	@Test
	public void testLowerShield() {
		shields.lowerShield();
		assertEquals(false, shields.isSheildUp());
	}
}
