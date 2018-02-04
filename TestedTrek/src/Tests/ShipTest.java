package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import StarTrek.Shields;
import StarTrek.Ship;

public class ShipTest {

	private Ship ship;
	
	@Before
	 public void initializeShip() {
		ship = new Ship();
	 }
	
	@Test
	public void verifyNewShipTest() {
				
		assertNotNull(ship.getShields());
		
		assertTrue(!ship.getShields().isSheildUp());
		
		assertEquals(Shields.MAX_SHIELD_LEVEL, ship.getShields().getLevel());
		
		assertEquals(Ship.MAX_ENERGY_LEVEL, ship.getEnergyLevel());
		
	}
	
		
	@Test
	public void transferEneryToShieldTest() {
		ship.getShields().increaseStrengthBy(-5000);
		
		ship.transferEnergyToShield(1000);
		
		assertEquals(ship.getEnergyLevel(), ship.MAX_ENERGY_LEVEL-1000);
		
		assertEquals(ship.getShields().getLevel(),(Shields.MAX_SHIELD_LEVEL-5000) + 1000);
		
	}
	
	@Test
	public void transferTooMuchEnergyToSheildTest() {
		//to dofff

}
