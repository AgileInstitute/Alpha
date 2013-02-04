package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Position;
import com.ebay.csd.superstartrek.Ship;

public class ShipTest {

	@Test
	public void hasEnergyReserve() {
		int startingEnergy = 1;
		Ship ship = new Ship(startingEnergy);
		ship.hit(2);
		Assert.assertEquals(-1, ship.getEnergyReserve());		
	}
	
	@Test
	public void hasShields() {
		int startingEnergy = 1000;
		int startingShields = 1;
		Ship ship = new Ship(startingEnergy, startingShields);
		ship.hit(2);
		Assert.assertEquals(999, ship.getEnergyReserve());		
		Assert.assertEquals(0, ship.getShields());		
	}
	
	@Test
	public void hasWarpEngine() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship ship = new Ship(startingEnergy, startingShields);
		ship.hit(500);
		Assert.assertEquals(600, ship.getEnergyReserve());		
		Assert.assertEquals(0, ship.getShields());		
		Assert.assertEquals(-6, ship.warpEngineHealth());
	}

	@Test
	public void hasPhaser() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship ship = new Ship(startingEnergy, startingShields);
		ship.hit(501);
		Assert.assertEquals(599, ship.getEnergyReserve());		
		Assert.assertEquals(0, ship.getShields());		
		Assert.assertEquals(-4, ship.phaserHealth());
	}
	
	public void getCurrentShipPosition(){
		Position pos = new Position (3,5);
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise =  new Ship (startingEnergy, startingShields);
		enterprise.setPosition(pos);
		Assert.assertEquals(3, enterprise.getPosition().getX());
		Assert.assertEquals(5, enterprise.getPosition().getY());
	}

}
