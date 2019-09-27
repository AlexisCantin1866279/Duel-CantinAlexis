package concretes.weapon;

import abstracts.fighter.IFighter;
import abstracts.weapon.ICapacity;
import abstracts.weapon.IWeapon;

public class PotionCapacity implements ICapacity {

	@Override
	public int getPowerCapacity(IFighter fighter, IWeapon weapon) {
		return fighter.getDexterity() * weapon.getPower() / 100;
	}

}
