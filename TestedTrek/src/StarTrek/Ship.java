package StarTrek;

public class Ship {
	public static final int MAX_ENERGY_LEVEL = 80000;
	public static final int MIN_ENERGY_LEVEL = 1;
	int energyLevel = MAX_ENERGY_LEVEL;
	private Shields shields = new Shields();
		

	public Shields getShields() {
		return shields;
	}

	public void setShields(Shields shields) {
		this.shields = shields;
	}

	public int getEnergyLevel() {	
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	public void transferEnergyToShield(int amount) {
		
		changeEnergy(amount);
		getShields().increaseStrengthBy(amount);
	}
	
	public void changeEnergy(int amount) {
		if (getShields().getLevel() + amount > Shields.MAX_SHIELD_LEVEL) {
			amount = Shields.MAX_SHIELD_LEVEL - getShields().getLevel();
		}
		setEnergyLevel(getEnergyLevel() - amount);
		if (getEnergyLevel() < MIN_ENERGY_LEVEL) {
			setEnergyLevel(MIN_ENERGY_LEVEL);
		} else if (getEnergyLevel() > MAX_ENERGY_LEVEL) {
			setEnergyLevel(MAX_ENERGY_LEVEL);
		}
	}
	

}
