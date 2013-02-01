package com.ebay.csd.superstartrek.test;

import org.junit.Assert;
import org.junit.Test;

import com.ebay.csd.superstartrek.Phaser;
import com.ebay.csd.superstartrek.SubSystem;
public class PhaserTest {

	@Test
	public void phaserTakesDamage(){
		SubSystem phaser = new Phaser(1000);
		int firePower = 300;
		phaser.takesDamage(firePower);
		Assert.assertEquals(7, phaser.remainingStarDate());
	}

	@Test
	public void checkPhaserLifeAtCreation(){
		SubSystem phaser = new Phaser(1000);
		Assert.assertEquals(10, phaser.remainingStarDate());
	}
	
	@Test
	public void repairPhaser(){
		SubSystem phaser = new Phaser(1000);
		phaser.takesDamage(600);
		phaser.repair(2);
		Assert.assertEquals(600,phaser.getRemainingEnergy());
	}
}
