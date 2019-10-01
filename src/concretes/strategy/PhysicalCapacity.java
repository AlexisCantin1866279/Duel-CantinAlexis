package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

public abstract class PhysicalCapacity extends Weapon {

	public PhysicalCapacity(int power) {
		super(power);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getStrength() * this.getPower() / 100;
	}

}
