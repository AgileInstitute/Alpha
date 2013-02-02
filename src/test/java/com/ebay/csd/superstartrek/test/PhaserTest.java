package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Phaser;
import com.ebay.csd.superstartrek.SubSystem;
public class PhaserTest {

	@Test
	public void phaserTakesDamage(){
		SubSystem phaser = new Phaser();
		int firePower = 300;
		phaser.takesDamage(firePower);
		Assert.assertEquals(-3, phaser.remainingStarDate());
	}

	@Test
	public void checkPhaserLifeAtCreation(){
		SubSystem phaser = new Phaser();
		Assert.assertEquals(0, phaser.remainingStarDate());
	}
	
	@Test
	public void repairPhaser(){
		SubSystem phaser = new Phaser();
		phaser.takesDamage(600);
		phaser.repair(2);
		Assert.assertEquals(-4,phaser.remainingStarDate());
	}
}
