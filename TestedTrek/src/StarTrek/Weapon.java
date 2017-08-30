package StarTrek;

public class Weapon extends SubSystem{

	
boolean isDamaged = true;
	
	public boolean isDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}
	
	public void damageTaken() {
		setDamaged(true);
	}
}
