package concretes.fighter;

import abstracts.fighter.IFighter;
import exceptions.fighter.IllegalSkillPoints;

public abstract class Fighter implements IFighter {

	public static final int MAX_SKILLS = 100;
	public static final int BASE_HP = 200;

	private String name;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int concentration;
	private int lifePoint;

	public Fighter(String name, int strength, int dexterity, int intelligence, int concentration) {
		validateSkills(strength, dexterity, intelligence, concentration);
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		this.lifePoint = BASE_HP - (strength + dexterity + intelligence + concentration);
	}

	public String getName() {
		return this.name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strenght) {
		this.strength = strenght;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getConcentration() {
		return concentration;
	}

	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	private void validateSkills(int strength, int dexterity, int intelligence, int concentration) {
		if (strength + dexterity + intelligence + concentration > MAX_SKILLS)
			throw new IllegalSkillPoints();
	}

}
