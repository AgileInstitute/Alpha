package StarTrek;

public class Shields {
	
	public static final int MAX_SHIELD_LEVEL = 10000;
	private int level = MAX_SHIELD_LEVEL;

	public int getLevel() {
		return level;
	}

	public void increaseStrengthBy(int delta) {
		level += delta;
		if(level>MAX_SHIELD_LEVEL){
			this.level = MAX_SHIELD_LEVEL;
		}
	}

}
