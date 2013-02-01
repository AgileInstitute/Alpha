package com.ebay.csd.superstartrek.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Shield;
import com.ebay.csd.superstartrek.SubSystem;
import com.ebay.csd.superstartrek.WarpEngine;

public class EnergyReserveTest {

	@Test
	public void newReserveEnergy() {
		EnergyReserve er = new EnergyReserve();
		Assert.assertEquals(6000, er.getEnergy());		
	}

	
	public void loseEnergy() {
		EnergyReserve er = new EnergyReserve();
		er.loseEnergy(4000);
		Assert.assertEquals(2000, er.getEnergy());	
	}
	


}
