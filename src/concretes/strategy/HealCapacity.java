package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

public abstract class HealCapacity extends Weapon {

	public HealCapacity(int power) {
		super(power);
	}
	
	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getIntelligence() * this.getPower() / 100;
	}

}
