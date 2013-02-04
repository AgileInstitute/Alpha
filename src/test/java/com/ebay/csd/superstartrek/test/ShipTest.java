package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.RandomNumberGenerator;
import com.ebay.csd.superstartrek.Ship;
import com.ebay.csd.test.superstartrek.RandomMock;

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
		RandomMock rand = new RandomMock();
		rand.nextHit(0);
		Ship ship = new Ship(startingEnergy, startingShields, rand);
		ship.hit(500);
		Assert.assertEquals(600, ship.getEnergyReserve());		
		Assert.assertEquals(0, ship.getShields());		
		Assert.assertEquals(-6, ship.warpEngineHealth());
	}

	@Test
	public void hasPhaser() {
		int startingEnergy = 1000;
		int startingShields = 100;
		RandomMock rand = new RandomMock();
		rand.nextHit(1);
		Ship ship = new Ship(startingEnergy, startingShields, rand);
		ship.hit(501);
		Assert.assertEquals(599, ship.getEnergyReserve());		
		Assert.assertEquals(0, ship.getShields());		
		Assert.assertEquals(-4, ship.phaserHealth());
	}
	
	@Test
	public void repairAllSubsystems() {
		int startingEnergy = 1000;
		Ship ship = new Ship(startingEnergy);
		ship.damagePhaser(3);
		ship.damageEngine(1);
		ship.rest(2);
		Assert.assertEquals(-1, ship.phaserHealth());
		Assert.assertEquals(0, ship.warpEngineHealth());
	}
	
	@Test
	public void randomlyAssignDamageToSubsystem() {
		int startingEnergy = 2;
		int startingShields = 1;
		RandomMock randmock = new RandomMock();
		randmock.nextHit(1);
		Ship ship = new Ship(startingEnergy, startingShields, randmock);
		ship.hit(101);
		Assert.assertEquals(-1, ship.phaserHealth());
	}

}
