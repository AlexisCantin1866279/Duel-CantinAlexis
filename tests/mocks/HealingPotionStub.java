package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.fighter.AthleteTest;

public class HealingPotionStub implements IWeapon {
	
	public int attackValue = AthleteTest.ATHLETE_DEXTERITY;

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		// TODO Auto-generated method stub
		return attackValue;
	}

	@Override
	public weaponType getWeaponType() {
		// TODO Auto-generated method stub
		return null;
	}

}
