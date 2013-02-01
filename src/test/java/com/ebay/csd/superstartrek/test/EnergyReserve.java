package com.ebay.csd.superstartrek.test;

public class EnergyReserve {
	
	int energy = 6000;

	public int getEnergy() {
		return energy;
	}

	public void loseEnergy(int i) {
		energy -= i;
		
	}

}
