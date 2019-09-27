package concretes.weapon;

import abstracts.fighter.IFighter;
import abstracts.strategy.ICapacity;
import abstracts.strategy.IFabricCapacity;
import abstracts.weapon.IWeapon;
import concretes.strategy.FabricCapacity;
import exceptions.weapon.IllegalWeaponPower;

public abstract class Weapon implements IWeapon {

	public static final int MIN_POWER = 20;
	public static final int MAX_POWER = 100;

	private int power;
	private weaponType type;

	public Weapon(int power, weaponType type) {
		validatePower(power);
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

	public int attack(IFighter fighter) {
		IFabricCapacity fabric = new FabricCapacity();
		ICapacity capacity = fabric.create(this.type);
		return capacity.getPowerCapacity(fighter, this);
	}

}
