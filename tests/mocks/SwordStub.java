package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.fighter.WarriorTest;

public class SwordStub implements IWeapon {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int attack(IFighter fighter) {
		// TODO Auto-generated method stub
		return WarriorTest.WARRIOR_STRENGTH;
	}

}