package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;
import concretes.fighter.Wizard;
import concretes.fighter.WizardTest;

public class FireBallStub implements IWeapon, IAttack {

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		// TODO Auto-generated method stub
		return WizardTest.WIZARD_INTELLIGENCE * Wizard.WIZARD_DELTA_SILLS;
	}

}
