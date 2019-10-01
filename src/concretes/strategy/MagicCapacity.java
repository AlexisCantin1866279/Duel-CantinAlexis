package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

public abstract class MagicCapacity extends Weapon {
	
	public MagicCapacity(int power) {
		super(power);
	}

	public static final int MAGIC_EFFECT = 3;
	
	@Override
	public int getCapacityPower(IFighter fighter) {
		return (fighter.getIntelligence() * this.getPower() / 100) * MAGIC_EFFECT;
	}

}
