package concretes.strategy;

import abstracts.fighter.IFighter;
import abstracts.strategy.ICapacity;
import abstracts.weapon.IWeapon;

public class MagicCapacity implements ICapacity {

	@Override
	public int getPowerCapacity(IFighter fighter, IWeapon weapon) {
		return (fighter.getIntelligence() * weapon.getPower() / 100) * 3;
	}

}
