package concretes.weapon;

import abstracts.weapon.IWeapon;
import exceptions.weapon.IllegalWeaponPower;

public abstract class Weapon implements IWeapon {

	public static final int MIN_POWER = 20;
	public static final int MAX_POWER = 100;

	private String name;
	private int power;
	private weaponType type;

	public Weapon(String name, int power, weaponType type) {
		validatePower(power);
		this.name = name;
		this.power = power;
		this.type = type;
	}

	private void validatePower(int power) {
		if (power < MIN_POWER || power > MAX_POWER)
			throw new IllegalWeaponPower();
	}
	
	public int getPower() {
		return this.power;
	}
	
	

}
