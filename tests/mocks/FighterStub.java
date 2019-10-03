package mocks;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;
import concretes.duel.Duel;

public class FighterStub implements IFighter {
	
	public static final int HP_TO_HEAL = 10;
	public static final int BASE_HP = 100;

	public int dexterity = 10;
	public int strength = 20;
	public int intelligence = 30;
	public int concentration = 0;
	public int hp = BASE_HP;
	public int power = HP_TO_HEAL;
	
	public boolean destroy = false;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return strength;
	}

	@Override
	public void setStrength(int strength) {
		this.strength += Duel.REWARD_DELTA;
	}

	@Override
	public int getDexterity() {
		// TODO Auto-generated method stub
		return dexterity;
	}

	@Override
	public void setDexterity(int dexterity) {
		this.dexterity += Duel.REWARD_DELTA;

	}

	@Override
	public int getIntelligence() {
		// TODO Auto-generated method stub
		return intelligence;
	}

	@Override
	public void setIntelligence(int intelligence) {
		this.intelligence += Duel.REWARD_DELTA;

	}

	@Override
	public int getConcentration() {
		return concentration;
	}

	@Override
	public void setConcentration(int concentration) {
		this.concentration += Duel.REWARD_DELTA;

	}

	@Override
	public int getLifePoint() {
		// TODO Auto-generated method stub
		return this.hp;
	}

	@Override
	public void setLifePoint(int lifePoint) {
		this.hp = lifePoint;
	}

	@Override
	public int getInitialLifePoint() {
		// TODO Auto-generated method stub
		return BASE_HP;
	}

	@Override
	public void provoke(IFighter defender, IAttack attackerWeapon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void challenge(IDuel duelChallenger) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surrender() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPower(IWeapon weapon) {
		// TODO Auto-generated method stub
		return this.power;
	}

	@Override
	public void nurse(IHealing healingCapacity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyWeapon(IWeapon weapon) {
		destroy = true;
		
	}

	@Override
	public void hitBack(IAttack defenderWeapon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitBack(IParade defenderWeapon) {
		// TODO Auto-generated method stub
		
	}

}
