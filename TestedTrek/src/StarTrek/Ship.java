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
	
	
	public void transferEnergyToShield(int amount) {
		
	}
	
}
