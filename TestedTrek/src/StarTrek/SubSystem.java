package StarTrek;

public class SubSystem {
	boolean damaged = false;

	public boolean isDamaged() {
		return damaged;
	}

	public void damage() {
		this.damaged = true;
	}

	public void repair() {
		this.damaged = false;
	}
}
