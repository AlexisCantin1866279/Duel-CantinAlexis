package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;

public class WeaponDummy implements IWeapon, IAttack {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
