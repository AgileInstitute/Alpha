package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import StarTrek.Weapon;

public class WeaponTest {


	private Weapon weapon;
	
	@Before
	public void setup() {
		weapon = new Weapon();
	}

	
	@Test
	public void testWeaponInitallyUndamaged() {
		assertTrue(weapon.isDamaged());
	}
	
	@Test
	public void hitShieldDown() {
		weapon.damageTaken();
		assertTrue(weapon.isDamaged());
	}

	
	@Test
	public void hitSheldTakesSomeOfDamage() {
		weapon.damageTaken();
		assertTrue(weapon.isDamaged());
	}
}
