package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Phaser;
public class PhaserTest {

	@Test
	public void phaserTakesDamage(){
		Phaser phaser = new Phaser();
		int firePower = 300;
		phaser.takesDamage(firePower);
		Assert.assertEquals(3, phaser.timeToRepair());
	}

	@Test
	public void checkPhaserLifeAtCreation(){
		Phaser phaser = new Phaser();
		Assert.assertEquals(0, phaser.timeToRepair());
	}
}
