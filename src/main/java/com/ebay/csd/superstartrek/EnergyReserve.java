package com.ebay.csd.superstartrek;

public class EnergyReserve {
	
	int energy;

	public EnergyReserve(int startingEnergy) {
		energy = startingEnergy;
	}

	public int getEnergy() {
		return energy;
	}

	public void loseEnergy(int i) {
		energy -= i;
		
	}

}
