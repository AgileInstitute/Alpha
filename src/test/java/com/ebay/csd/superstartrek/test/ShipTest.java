package com.ebay.csd.superstartrek.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Position;
import com.ebay.csd.superstartrek.Ship;
import com.ebay.csd.superstartrek.StarBase;

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

	@Test
	public void getCurrentShipPosition() {
		Position pos = new Position(3, 5);
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		enterprise.setPosition(pos);
		Assert.assertEquals(3, enterprise.getPosition().getX());
		Assert.assertEquals(5, enterprise.getPosition().getY());
	}

	@Test
	public void shipIsDocked() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		enterprise.dock();
		Assert.assertTrue(enterprise.isDocked());
	}

	@Test
	public void shipIsNotDocked() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		Assert.assertFalse(enterprise.isDocked());
	}

	@Test
	public void shipIsUnDocked() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		enterprise.dock();
		enterprise.unDock();
		Assert.assertFalse(enterprise.isDocked());
	}

	@Test
	public void hitAShipWhenDocked() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		enterprise.dock();
		enterprise.hit(1000);
		Assert.assertEquals(1000, enterprise.getEnergyReserve());
		Assert.assertEquals(100, enterprise.getShields());
		Assert.assertEquals(0, enterprise.phaserHealth());
		Assert.assertEquals(0, enterprise.phaserHealth());
	}

	@Test
	public void shipNearStarBase() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		List<StarBase> starBases = new ArrayList<StarBase>();
		starBases.add(new StarBase(new Position(3, 5)));
		starBases.add(new StarBase(new Position(4, 5)));
		starBases.add(new StarBase(new Position(5, 5)));
		starBases.add(new StarBase(new Position(3, 4)));
		starBases.add(new StarBase(new Position(4, 4)));
		starBases.add(new StarBase(new Position(5, 4)));
		starBases.add(new StarBase(new Position(3, 3)));
		starBases.add(new StarBase(new Position(4, 3)));
		starBases.add(new StarBase(new Position(5, 3)));
		enterprise.setPosition(new Position(4, 4));

		List<StarBase> nearestStarBases = enterprise
				.getNearestDockableStarBase(starBases);
		// for (StarBase sBase:nearestStarBases){
		for (int i = 0; i < nearestStarBases.size(); i++) {
			Assert.assertTrue(nearestStarBases.get(i).getPosition()
					.equals(starBases.get(i).getPosition()));
		}
	}
	
	@Test
	public void shipNotNearStarBase() {
		int startingEnergy = 1000;
		int startingShields = 100;
		Ship enterprise = new Ship(startingEnergy, startingShields);
		List<StarBase> starBases = new ArrayList<StarBase>();
		starBases.add(new StarBase(new Position(1, 2)));
		starBases.add(new StarBase(new Position(2, 1)));
		starBases.add(new StarBase(new Position(6, 6)));
		starBases.add(new StarBase(new Position(2, 3)));
		enterprise.setPosition(new Position(4, 4));

		List<StarBase> nearestStarBases = enterprise
				.getNearestDockableStarBase(starBases);
		Assert.assertEquals(0,nearestStarBases.size());
	}

}
