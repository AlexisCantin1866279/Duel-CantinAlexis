package mocks;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IWeapon;
import concretes.infirmary.Infirmary;

public class FighterSpy implements IFighter {

	public boolean destroyWeaponHasBeenCalled = false;
	public boolean challengeRequest = false;
	
	public boolean strengthHaveBeenCalled = false;
	public boolean dexterityHaveBeenCalled = false;
	public boolean intelligenceHaveBeenCalled = false;
	public boolean concentrationHaveBeenCalled = false;
	public boolean lifeHaveBeenCalled = false;
	
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
		this.strengthHaveBeenCalled = true;
		
	}

	@Override
	public int getDexterity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDexterity(int dexterity) {
		this.dexterityHaveBeenCalled = true;
		
	}

	@Override
	public int getIntelligence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIntelligence(int intelligence) {
		this.intelligenceHaveBeenCalled = true;
		
	}

	@Override
	public int getConcentration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setConcentration(int concentration) {
		this.concentrationHaveBeenCalled = true;
		
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
		this.lifeHaveBeenCalled = true;
		
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

	@Override
	public void provoke(IFighter defender, IAttack attackerWeapon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void challenge(IDuel duelChallenger) {
		this.challengeRequest = true;
		
	}

	@Override
	public void hitBack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surrender() {
		// TODO Auto-generated method stub
		
	}

}
