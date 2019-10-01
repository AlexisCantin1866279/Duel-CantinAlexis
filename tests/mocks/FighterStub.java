package mocks;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon.weaponType;

public class FighterStub implements IFighter {
	
	public static final int HP_TO_HEAL = 10;
	public static final int BASE_HP = 100;

	public int dexterity = 10;
	public int strength = 20;
	public int intelligence = 30;
	public int hp = BASE_HP;
	public weaponType type = weaponType.HEAL;

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
		// TODO Auto-generated method stub

	}

	@Override
	public int getDexterity() {
		// TODO Auto-generated method stub
		return dexterity;
	}

	@Override
	public void setDexterity(int dexterity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getIntelligence() {
		// TODO Auto-generated method stub
		return intelligence;
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
		return this.hp;
	}

	@Override
	public void setLifePoint(int lifePoint) {
		this.hp = lifePoint;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return HP_TO_HEAL;
	}

	@Override
	public weaponType getWeaponType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public int getInitialLifePoint() {
		// TODO Auto-generated method stub
		return BASE_HP;
	}

}
