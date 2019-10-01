package concretes.weapon;

import abstracts.weapon.IWeapon;
import exceptions.weapon.IllegalWeaponPower;

public abstract class Weapon implements IWeapon {

	public static final int MIN_POWER = 20;
	public static final int MAX_POWER = 100;

	protected int power;

	public Weapon(int power) {
		validatePower(power);
		this.power = power;
	}

	private void validatePower(int power) {
		if (power < MIN_POWER || power > MAX_POWER)
			throw new IllegalWeaponPower();
	}

	public int getPower() {
		return this.power;
	}
}
