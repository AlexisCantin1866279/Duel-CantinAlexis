package concretes.weapon;

import abstracts.fighter.IFighter;
import abstracts.strategy.ICapacity;
import abstracts.strategy.IFabricCapacity;
import abstracts.weapon.IWeapon;
import concretes.strategy.FabricCapacity;
import exceptions.weapon.IllegalAttack;
import exceptions.weapon.IllegalWeaponPower;

public abstract class Weapon implements IWeapon {

	public static final int MIN_POWER = 20;
	public static final int MAX_POWER = 100;

	private int power;
	private attackType attackType;
	private weaponType weapontype;

	public Weapon(int power, weaponType weapontype, attackType attackType) {
		validatePower(power);
		this.power = power;
		this.weapontype = weapontype;
		this.attackType = attackType;
	}

	private void validatePower(int power) {
		if (power < MIN_POWER || power > MAX_POWER)
			throw new IllegalWeaponPower();
	}

	public int getPower() {
		return this.power;
	}
	
	public weaponType getWeaponType() {
		return this.weapontype;
	}

	public int attack(IFighter fighter) {
		validateAttack();
		IFabricCapacity fabric = new FabricCapacity();
		ICapacity capacity = fabric.create(this.attackType); //mettre les deux variables a l'exterieur??
		return capacity.getPowerCapacity(fighter, this);
	}
	
	private void validateAttack() {
		if (this.weapontype == weaponType.HEAL) throw new IllegalAttack();
	}

}
