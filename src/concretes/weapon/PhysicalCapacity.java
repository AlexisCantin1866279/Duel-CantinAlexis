package concretes.weapon;

import abstracts.fighter.IFighter;
import abstracts.weapon.ICapacity;
import abstracts.weapon.IWeapon;

public class PhysicalCapacity implements ICapacity {

	@Override
	public int getPowerCapacity(IFighter fighter, IWeapon weapon) {
		return fighter.getStrength() * weapon.getPower() / 100;
	}

}
