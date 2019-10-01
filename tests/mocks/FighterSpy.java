package mocks;

import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IHealing;
import abstracts.weapon.IWeapon;
import concretes.infirmary.Infirmary;

public class FighterSpy implements IFighter {

	public boolean destroyWeaponHasBeenCalled = false;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStrength(int strength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDexterity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDexterity(int dexterity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIntelligence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIntelligence(int intelligence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getConcentration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setConcentration(int concentration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLifePoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitialLifePoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLifePoint(int lifePoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void nurse() {
		IInfirmary infirmary = new Infirmary();
		IWeapon healingSpellStub = new HealingSpellStub();
		infirmary.nurse(this, (IHealing) healingSpellStub);
		
	}

	@Override
	public void destroyWeapon() {
		destroyWeaponHasBeenCalled = true;
		
	}

}
