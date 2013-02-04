package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.EnergyReserve;

public class EnergyReserveTest {

	@Test
	public void newReserveEnergy() {
		EnergyReserve er = new EnergyReserve(6000);
		Assert.assertEquals(6000, er.getEnergy());		
	}

	
	public void loseEnergy() {
		EnergyReserve er = new EnergyReserve(6000);
		er.loseEnergy(4000);
		Assert.assertEquals(2000, er.getEnergy());	
	}
	


}
