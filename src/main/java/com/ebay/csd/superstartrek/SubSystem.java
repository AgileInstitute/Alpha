package com.ebay.csd.superstartrek;

public abstract class SubSystem {

	private int starDate;
	
	public Object timeToRepair() {
		return starDate;
	}

	public void takesDamage(int firePower) {
		starDate += firePower/energyPerStardate();
	}

	public abstract int energyPerStardate();
}
