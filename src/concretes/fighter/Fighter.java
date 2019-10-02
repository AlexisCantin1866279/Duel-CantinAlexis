package concretes.fighter;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IWeapon;
import concretes.duel.Duel;
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
	private IDuel duel;
	private IDuel challengerDuel = null;

	public Fighter(String name, int strength, int dexterity, int intelligence, int concentration, IWeapon weapon) {
		validateSkills(strength, dexterity, intelligence, concentration);
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		this.lifePoint = BASE_HP - (strength + dexterity + intelligence + concentration);
		INITIAL_HP = this.lifePoint;
		
		this.weapon = weapon; // mettre en list pour en posseder plus qu'une
		
		this.infirmary = new Infirmary();
		this.duel = new Duel(this);
	}
	
	private void validateSkills(int strength, int dexterity, int intelligence, int concentration) {
		if (strength + dexterity + intelligence + concentration > MAX_SKILLS)
			throw new IllegalSkillPoints();
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

	public void provoke(IFighter defender, IAttack attackerWeapon) {
		this.duel.provoke(defender, attackerWeapon);
	}
	
	public void challenge(IDuel duelChallenger) {
		this.challengerDuel = duelChallenger;
	}
	
	public void hitBack() {
		this.challengerDuel.fight();
	}
	
	public void surrender() {
		this.challengerDuel.surrender();
	}

}
