package com.ebay.csd.superstartrek;

public abstract class SubSystem {

	protected int starDate;
	
	public int remainingStarDate() {
		return starDate;
	}

	public void takesDamage(int firePower) {
		starDate -= firePower/energyPerStardate();
	}

	public void repair(int repairStarDays) {
		starDate += repairStarDays;
	}
	
	public abstract int energyPerStardate();

	public int getRemainingEnergy() {
		return starDate*energyPerStardate();
	}
}
