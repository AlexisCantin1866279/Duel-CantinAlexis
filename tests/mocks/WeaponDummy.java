package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;

public class WeaponDummy implements IWeapon {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int attack(IFighter fighter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public weaponType getWeaponType() {
		// TODO Auto-generated method stub
		return null;
	}

}
