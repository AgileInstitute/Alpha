package StarTrek;

public class Shields extends SubSystem{
	
	public static final int MAX_SHIELD_LEVEL = 10000;
	public static final int MIN_SHIELD_LEVEL = 0;
	private int level = MAX_SHIELD_LEVEL;

	private boolean shieldUp = false;
		
	public int getLevel() {
		return level;
	}

	public void increaseStrengthBy(int delta) {
		level += delta;
		if(level>MAX_SHIELD_LEVEL){
			this.level = MAX_SHIELD_LEVEL;
		}else if(level<MIN_SHIELD_LEVEL) {
			this.level = MIN_SHIELD_LEVEL;
		}
	}

	public void raiseShield() {
		shieldUp = true;
	}

	public void lowerShield() {
		shieldUp = false;
	}

	public boolean isSheildUp() {
		return shieldUp;
	}
	
	

}

