package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.fighter.WizardTest;

public class HealingSpellStub implements IWeapon {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int attack(IFighter fighter) {
		// TODO Auto-generated method stub
		return WizardTest.WIZARD_INTELLIGENCE;
	}

}
