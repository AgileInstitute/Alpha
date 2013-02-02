package com.ebay.csd.superstartrek;

public class Ship {

	private EnergyReserve energyReserve;
	private Shield shield;
	private WarpEngine warpEngine = new WarpEngine();
	private Phaser phaser = new Phaser();
	
	public Ship(int startingEnergy) {
		this.energyReserve = new EnergyReserve(startingEnergy);
	}

	public Ship(int startingEnergy, int startingShields) {
		this.energyReserve = new EnergyReserve(startingEnergy);
		this.shield = new Shield(startingShields);
	}

	public int getEnergyReserve() {
		return this.energyReserve.getEnergy();
	}

	public void hit(int i) {
		int overflow = i;
		if (this.shield != null) {
			overflow = this.shield.absorb(overflow);
		}
		this.energyReserve.loseEnergy(overflow);
		if (overflow > 0 && overflow % 2 == 0) {
			this.warpEngine.takesDamage(overflow);
		} else if (overflow > 0) {
			this.phaser.takesDamage(overflow);
		}
		if (this.energyReserve.getEnergy() < 0) {
			System.out.println("GAME OVER SUCKER");
		}
	}

	public int getShields() {
		return this.shield.getEnergy();
	}

	public int warpEngineHealth() {
		return warpEngine.remainingStarDate();
	}

	public int phaserHealth() {
		return phaser .remainingStarDate();
	}

}
