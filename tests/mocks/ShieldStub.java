package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;
import concretes.fighter.WarriorTest;

public class ShieldStub implements IWeapon, IParade {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		// TODO Auto-generated method stub
		return WarriorTest.WARRIOR_STRENGTH;
	}

}
