package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.SubSystem;
import com.ebay.csd.superstartrek.WarpEngine;

public class WarpEngineTest {

	@Test
	public void repairWarpEngine(){
		SubSystem engine = new WarpEngine(1200);
		engine.takesDamage(600);
		engine.repair(2);
		Assert.assertEquals(720,engine.getRemainingEnergy());
	}
	
	@Test
	public void warpEngineTakesDamage(){
		SubSystem engine = new WarpEngine(1200);
		int firePower = 300;
		engine.takesDamage(firePower);
		Assert.assertEquals(15, engine.remainingStarDate());
	}
	
}
