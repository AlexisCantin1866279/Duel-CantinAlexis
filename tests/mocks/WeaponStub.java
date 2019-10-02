package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;

public class WeaponStub implements IWeapon, IAttack {
	
	public int power = 10;

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return power;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
