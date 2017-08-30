package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import StarTrek.Shields;
import StarTrek.Ship;

public class ShipTest {

	
	@Test
	public void verifyNewShipTest() {
		Ship ship = new Ship();
		
		assertNotNull(ship.getShields());
		
		assertEquals(true, ship.getShields().isSheildUp());
		
		assertEquals(Shields.MAX_SHIELD_LEVEL, ship.getShields().getLevel());
		
	}

}
