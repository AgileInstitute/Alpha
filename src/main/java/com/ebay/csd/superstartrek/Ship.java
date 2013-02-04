package com.ebay.csd.superstartrek;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private EnergyReserve energyReserve;
	private Shield shield;
	private Position pos = new Position(0, 0);
	private WarpEngine warpEngine = new WarpEngine();
	private Phaser phaser = new Phaser();
	private List<SubSystem> subsystems = new ArrayList<SubSystem>();
	private RandomNumberGenerator rand;
	private boolean dock = false;

	public Ship(int startingEnergy) {
		this.energyReserve = new EnergyReserve(startingEnergy);
		this.subsystems.add(this.warpEngine);
		this.subsystems.add(this.phaser);
		this.rand = new RandomNumberGenerator();
	}

	public Ship(int startingEnergy, int startingShields) {
		this.energyReserve = new EnergyReserve(startingEnergy);
		this.shield = new Shield(startingShields);
		this.subsystems.add(this.warpEngine);
		this.subsystems.add(this.phaser);
		this.rand = new RandomNumberGenerator();
	}

	public Ship(int startingEnergy, int startingShields, RandomNumberGenerator rand) {
		this.energyReserve = new EnergyReserve(startingEnergy);
		this.shield = new Shield(startingShields);
		this.subsystems.add(this.warpEngine);
		this.subsystems.add(this.phaser);
		this.rand = rand;
	}

	public int getEnergyReserve() {
		return this.energyReserve.getEnergy();
	}

	public void hit(int i) {
		if (isDocked())
			return;
		int overflow = i;
		if (this.shield != null) {
			overflow = this.shield.absorb(overflow);
		}
		this.energyReserve.loseEnergy(overflow);
		int subsystemHit = rand.rand(subsystems.size() - 1);
		this.subsystems.get(subsystemHit).takesDamage(overflow);

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
		return phaser.remainingStarDate();
	}

	public void damagePhaser(int i) {
		phaser.takesStarDateDamage(i);
	}

	public void damageEngine(int i) {
		warpEngine.takesStarDateDamage(i);
	}

	public void rest(int i) {
		for (SubSystem subsystem: subsystems) {
			subsystem.repair(i);
		}
	}

	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}

	public void dock() {
		dock = true;

	}

	public boolean isDocked() {
		return dock;
	}

	public void unDock() {
		dock = false;
	}

	public List<StarBase> getNearestDockableStarBase(List<StarBase> starBases) {
		List<StarBase> NearestStarBases = new ArrayList<StarBase>();
		for (StarBase starBase : starBases) {
			if ((Math.abs(starBase.getPosition().getX() - pos.getX()) <= 1)
					|| (Math.abs(starBase.getPosition().getX() - pos.getX()) <= 1)) {
				NearestStarBases.add(starBase);
			}
		}
		return NearestStarBases;
	}

}
