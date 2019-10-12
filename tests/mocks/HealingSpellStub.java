package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IHealing;
import abstracts.weapon.IWeapon;
import concretes.fighter.WizardTest;

public class HealingSpellStub implements IWeapon, IHealing {

	@Override
	public int getPower() {
		return 0;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return WizardTest.WIZARD_INTELLIGENCE;
	}

}
