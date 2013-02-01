package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.SubSystem;
import com.ebay.csd.superstartrek.WarpEngine;

public class WarpEngineTest {

	@Test
	public void warpEngineTakesDamage(){
		SubSystem engine = new WarpEngine();
		int firePower = 300;
		engine.takesDamage(firePower);
		Assert.assertEquals(5, engine.timeToRepair());
	}
	
}
