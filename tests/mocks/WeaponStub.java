package mocks;

import abstracts.weapon.IWeapon;

public class WeaponStub implements IWeapon{
	
	public int power = 10;

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return power;
	}

}
