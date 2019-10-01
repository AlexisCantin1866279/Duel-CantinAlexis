package concretes.fighter;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import abstracts.weapon.IWeapon.weaponType;
import exceptions.fighter.IllegalSkillPoints;
import exceptions.infirmary.HealTypeException;

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
	
	public weaponType getWeaponType() {
		return this.weapon.getWeaponType();
	}
	
	public void destroyWeapon() {
		this.weapon = null;
	}
	
	public void nurse() {
		if (this.weapon.getWeaponType() != weaponType.HEAL) throw new HealTypeException();
	}

	private void validateSkills(int strength, int dexterity, int intelligence, int concentration) {
		if (strength + dexterity + intelligence + concentration > MAX_SKILLS)
			throw new IllegalSkillPoints();
	}

}
