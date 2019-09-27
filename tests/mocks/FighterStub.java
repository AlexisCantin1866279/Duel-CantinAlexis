package mocks;

import abstracts.fighter.IFighter;

public class FighterStub implements IFighter {

	public int dexterity = 10;
	public int strength = 20;
	public int intelligence = 30;

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
		return 0;
	}

	@Override
	public void setLifePoint(int lifePoint) {
		// TODO Auto-generated method stub

	}

}
