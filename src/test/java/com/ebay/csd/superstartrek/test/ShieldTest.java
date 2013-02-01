package com.ebay.csd.superstartrek.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Shield;
import com.ebay.csd.superstartrek.SubSystem;
import com.ebay.csd.superstartrek.WarpEngine;

public class ShieldTest {

	@Test
	public void newShieldEnergy() {
		Shield shield = new Shield();
		Assert.assertEquals(1000, shield.getEnergy());		
	}

	@Test
	public void absorbHit() {
		Shield shield = new Shield();
		shield.absorb(500);
		Assert.assertEquals(500, shield.getEnergy());		
	}

	public void depleteShields() {
		Shield shield = new Shield();
		int overflow = shield.absorb(2000);
		Assert.assertEquals(0, shield.getEnergy());
		Assert.assertEquals(1000, overflow);
	}

	public void transferEnergy() {
		Shield shield = new Shield();
		shield.transferEnergyIn(500);
		Assert.assertEquals(1500, shield.getEnergy());
	}

}
