package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;
import concretes.fighter.WarriorTest;

public class SwordStub implements IWeapon, IAttack {//MS IAttack extends IWeapon, on ne doit donc pas implémenter les deux interfaces.

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
