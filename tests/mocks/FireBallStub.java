package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.fighter.Wizard;
import concretes.fighter.WizardTest;

public class FireBallStub implements IWeapon {
	
	public weaponType type = weaponType.ATTACK;

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int attack(IFighter fighter) {
		// TODO Auto-generated method stub
		return WizardTest.WIZARD_INTELLIGENCE * Wizard.WIZARD_DELTA_SILLS;
	}

	@Override
	public weaponType getWeaponType() {
		// TODO Auto-generated method stub
		return type;
	}

}
