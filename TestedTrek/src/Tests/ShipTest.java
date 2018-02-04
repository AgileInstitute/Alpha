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
	public void transferToShield_TooMuchEnergy() {
		ship.getShields().increaseStrengthBy(- 100);
		int before = ship.getEnergyLevel();
		ship.transferEnergyToShield(200);
		assertEquals(ship.getEnergyLevel(), before - 100);
		assertEquals(ship.getShields().getLevel(), Shields.MAX_SHIELD_LEVEL);
	}

	@Test
	public void transferToShield_TooLittleShipEnergy() {
		ship.getShields().increaseStrengthBy(Shields.MAX_SHIELD_LEVEL);
		//assertEquals(ship.getEnergyLevel(), math here);
		assertEquals(ship.getShields().getLevel(),Shields.MAX_SHIELD_LEVEL);
	}

	
}
