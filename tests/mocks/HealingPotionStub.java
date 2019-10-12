package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.fighter.AthleteTest;

public class HealingPotionStub implements IWeapon {
	
	public int attackValue = AthleteTest.ATHLETE_DEXTERITY;//MS Un mock doit �tre r�utilisable, il ne faut pas qu'il soit li� � une classe de test

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

}
