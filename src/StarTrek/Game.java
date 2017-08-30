package StarTrek;

import java.util.Random;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import Untouchables.WebGadget;

public class Game {

	private static final String PHOTON = "photon";
	private static final String PHASER = "phaser";
	private int energy = 10000;
	private int torpedoes = 8;

    public int getEnergyRemaining() {
        return energy;
    }
    
    public void setEnergyRemaining(int energy) {
        this.energy = energy;
    }

    public void setTorpedoes(int value) {
    	torpedoes = value;
        }
    public int getTorpedoes() {
            return torpedoes;
        
    }

    public void fireWeapon(WebGadget wg) {
        fireWeapon(new Galaxy(wg));
    }

    public void fireWeapon(Galaxy galaxy) {
    	    	
        if (galaxy.parameter("command").equals(PHASER)) {
			firePhaser(galaxy);
		} else if (galaxy.parameter("command").equals(PHOTON)) {
			firePhoton(galaxy);
		}
	}

    /**
     * fire Photons
     * @param wg
     */
	public void firePhoton(Galaxy galaxy) {
		Klingon enemy = (Klingon) galaxy.variable("target");
		if (getTorpedoes()  > 0) {
			int distance = enemy.distance();
			if (isOutOfPhotonRange(distance)) {
				galaxy.writeLine("Torpedo missed Klingon at " + distance + " sectors...");
			} else {
				int damage = 800 + rnd(50);
				galaxy.writeLine("Photons hit Klingon at " + distance + " sectors with " + damage + " units");
				if (damage < enemy.getEnergy()) {
					enemy.setEnergy(enemy.getEnergy() - damage);
					galaxy.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
				} else {
					galaxy.writeLine("Klingon destroyed!");
					enemy.delete();
				}
			}
			
			reduceTorpedoes(1);
			

		} else {
			galaxy.writeLine("No more photon torpedoes!");
		}
	}

	private boolean isOutOfPhotonRange(int distance) {
		return rnd(4) + ((distance / 500) + 1) > 7;
	}

	/**
	 * fire Phasers
	 * @param galaxy
	 */
	public void firePhaser(Galaxy galaxy) {
		int amount = Integer.parseInt(galaxy.parameter("amount"));
		Klingon enemy = (Klingon) galaxy.variable("target");
		if (getEnergyRemaining() >= amount) {
			int distance = enemy.distance();
			if (isOutOfPhaserRange(distance)) {
				galaxy.writeLine("Klingon out of range of phasers at " + distance + " sectors...");
			} else {
				int damage = amount - (((amount /20)* distance /200) + rnd(200));
				if (damage < 1)
					damage = 1;
				galaxy.writeLine("Phasers hit Klingon at " + distance + " sectors with " + damage + " units");
				if (damage < enemy.getEnergy()) {
					enemy.setEnergy(enemy.getEnergy() - damage);
					galaxy.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
				} else {
					galaxy.writeLine("Klingon destroyed!");
					enemy.delete();
				}
			}
			reduceEnergy(amount);
			
		} else {
			galaxy.writeLine("Insufficient energy to fire phasers!");
		}
	}

	private boolean isOutOfPhaserRange(int distance) {
		return distance > 4000;
	}

    /**
     * Removes available torpedos by amount passed in
     * @param i
     */
    private void reduceTorpedoes(int firedTorpedos) {
    	setTorpedoes(getTorpedoes() - firedTorpedos);
	}

	/**
     * Reduce energy by amount passed in
     * @param amount
     */
    private void reduceEnergy(int amount) {

		setEnergyRemaining(getEnergyRemaining() - amount);
	}

	// note we made generator public in order to mock it
    // it's ugly, but it's telling us something about our *design!* ;-)
	public static Random generator = new Random();
	private static int rnd(int maximum) {
		return generator.nextInt(maximum);
	}


}
