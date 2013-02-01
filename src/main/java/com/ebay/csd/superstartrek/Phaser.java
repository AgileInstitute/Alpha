package com.ebay.csd.superstartrek;

public class Phaser extends SubSystem {
	//private int starDate = 0;

	public Phaser(int initialStarDate) {
		starDate = initialStarDate/energyPerStardate();
	}

	public int energyPerStardate() {
		return 100;
	}

}
