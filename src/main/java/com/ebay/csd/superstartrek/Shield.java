package com.ebay.csd.superstartrek;

public class Shield {

	private int energy;
	
	public Shield(int startingShields) {
		this.energy = startingShields;
	}

	public int getEnergy() {
		return energy;
	}

	public int absorb(int i) {
		this.energy -= i;
		int overflow = 0;
		if (this.energy < 0) {
			overflow = 0 - this.energy;
			this.energy = 0;
		}
		return overflow;
	}

	public void transferEnergyIn(int i) {
		this.energy += i;
	}

}
