package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

public abstract class PotionCapacity extends Weapon {

	public PotionCapacity(int power) {
		super(power);
	}
	
	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getDexterity() * this.getPower() / 100;
	}

}
