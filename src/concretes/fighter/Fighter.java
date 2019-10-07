package concretes.fighter;

import java.util.ArrayList;
import java.util.List;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;
import concretes.duel.Duel;
import exceptions.fighter.CapacityExistenceException;
import exceptions.fighter.IllegalFightException;
import exceptions.fighter.IllegalNumberCapacitiesStart;
import exceptions.fighter.IllegalSkillPoints;
import exceptions.fighter.ToManyWeaponException;

/**
 * Classe abstraite qui guide la creation d'un combattant
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 *
 */
public abstract class Fighter implements IFighter {

	public static final int MAX_SKILLS = 100;
	public static final int BASE_HP = 200;
	public static final int MIN_CAPACITIES = 2;

	private final int INITIAL_HP;

	private String name;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int concentration;
	private int lifePoint;
	private int numberMaxOfWeapons;

	private List<IWeapon> capacityList;
	private IDuel duel;
	private IDuel challengerDuel = null;

	/**
	 * Constructeur de tout combattant
	 * 
	 * @param name,          nom du combattant
	 * @param strength,      force physique du combattant
	 * @param dexterity,     dexterite du combattant
	 * @param intelligence,  intelligence du cmbattant
	 * @param concentration, concentration du combattant
	 * @param capacityList,  liste d'arme que le combattant possede, doit en
	 *                       posseder plus que 2
	 */
	public Fighter(String name, int strength, int dexterity, int intelligence, int concentration,
			List<IWeapon> capacityList) {
		validateSkills(strength, dexterity, intelligence, concentration);
		validateCapacity(capacityList);

		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		this.lifePoint = BASE_HP - (strength + dexterity + intelligence + concentration);
		INITIAL_HP = this.lifePoint;

		this.capacityList = new ArrayList<IWeapon>(capacityList);
		numberMaxOfWeapons = this.capacityList.size();

		this.duel = new Duel(this);
	}

	private void validateSkills(int strength, int dexterity, int intelligence, int concentration) {
		if (strength + dexterity + intelligence + concentration > MAX_SKILLS)
			throw new IllegalSkillPoints();
	}

	private void validateCapacity(List<IWeapon> capacityList) {
		if (capacityList.size() < MIN_CAPACITIES)
			throw new IllegalNumberCapacitiesStart();
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

	/**
	 * Permet d'avoir la puissance du combattant avec son arme
	 */
	public int getPower(IWeapon weapon) {
		return weapon.getCapacityPower(this);
	}

	/**
	 * Enleve une arme du combattant
	 */
	public void destroyWeapon(IWeapon weapon) {

		this.capacityList.remove(weapon);
		this.numberMaxOfWeapons--;
	}

	/**
	 * methode qui provoque un autre combattant en duel
	 */
	public void provoke(IFighter defender, IAttack attackerWeapon) {
		haveWeapon(attackerWeapon);
		this.duel.provoke(defender, attackerWeapon);
	}

	/**
	 * methode qui initialise un defi adverse
	 */
	public void challenge(IDuel duelChallenger) {
		this.challengerDuel = duelChallenger;
	}

	/**
	 * Permet d'accepter le duel, sinon lance exception
	 */
	public void hitBack(IAttack defenderWeapon) {
		if (this.challengerDuel == null)
			throw new IllegalFightException();
		haveWeapon(defenderWeapon);
		this.challengerDuel.fight(defenderWeapon);
	}

	/**
	 * Permet d'accepter le duel, sinon lance exception
	 */
	public void hitBack(IParade defenderWeapon) {
		if (this.challengerDuel == null)
			throw new IllegalFightException();
		haveWeapon(defenderWeapon);
		this.challengerDuel.fight(defenderWeapon);
	}

	/**
	 * Permet d'abandonner le combat si le combattant est provoque en duel, sinon
	 * lance exception
	 */
	public void surrender() {
		if (this.challengerDuel == null)
			throw new IllegalFightException();
		this.challengerDuel.surrender();
	}
	
	/**
	 * ajout une arme s'il a deja gagner un combat
	 */
	public void addWeapon(IWeapon weapon) {
		if (this.numberMaxOfWeapons <= this.capacityList.size())
			throw new ToManyWeaponException();
		this.capacityList.add(weapon);
	}

	public void increaseWeaponLimit() {
		this.numberMaxOfWeapons++;
	}

	public void haveWeapon(IWeapon weapon) {
		if (!this.capacityList.contains(weapon))
			throw new CapacityExistenceException();
	}

}
