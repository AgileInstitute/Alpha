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
		if (starDate > 0) {
			starDate = 0;
		}
	}
	
	public abstract int energyPerStardate();

	public int getRemainingEnergy() {
		return starDate*energyPerStardate();
	}
	
	public void takesStarDateDamage(int starDates) {
		starDate -= starDates;
	}
}
