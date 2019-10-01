package concretes.fighter;

import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IHealing;
import abstracts.weapon.IWeapon;
import concretes.infirmary.Infirmary;
import exceptions.fighter.IllegalSkillPoints;

public abstract class Fighter implements IFighter {

	public static final int MAX_SKILLS = 100;
	public static final int BASE_HP = 200;
	
	private final int INITIAL_HP;

	private String name;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int concentration;
	private int lifePoint;
	
	private IWeapon weapon;
	private IInfirmary infirmary;

	public Fighter(String name, int strength, int dexterity, int intelligence, int concentration, IWeapon weapon) {
		validateSkills(strength, dexterity, intelligence, concentration);
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		this.weapon = weapon; // mettre en list pour en posseder plus qu'une
		this.lifePoint = BASE_HP - (strength + dexterity + intelligence + concentration);
		INITIAL_HP = this.lifePoint;
		this.infirmary = new Infirmary();
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
	
	public int getInitialLifePoint() {
		return this.INITIAL_HP;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}
	
	public int getPower() {
		return this.weapon.getCapacityPower(this);
	}
	
	public void destroyWeapon() {
		this.weapon = null;
	}
	
	public void nurse() {
		this.infirmary.nurse(this, (IHealing) this.weapon);
	}

	private void validateSkills(int strength, int dexterity, int intelligence, int concentration) {
		if (strength + dexterity + intelligence + concentration > MAX_SKILLS)
			throw new IllegalSkillPoints();
	}

}
