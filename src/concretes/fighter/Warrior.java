package concretes.fighter;

import java.util.List;

import abstracts.weapon.IWeapon;
import exceptions.fighter.WarriorIllegalSkillPoints;

/**
 * Classe permettant d'implementer un combattant guerrier
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class Warrior extends Fighter {

	public static final int WARRIOR_DELTA_SKILLS = 10;

	public Warrior(String name, int strength, int dexterity, int intelligence, int concentration,
			List<IWeapon> capacityList) {
		super(name, strength, dexterity, intelligence, concentration, capacityList);
		validateWarriorSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateWarriorSkills(int strength, int dexterity, int intelligence, int concentration) {
		int dexterityDifference = dexterity + WARRIOR_DELTA_SKILLS;
		int intelligenceDifference = intelligence + WARRIOR_DELTA_SKILLS;
		boolean exceptionMustBeThrown = false;

		if (strength < dexterityDifference) {
			exceptionMustBeThrown = true;
		} else if (dexterityDifference < intelligenceDifference) {
			exceptionMustBeThrown = true;
		} else if (intelligenceDifference < concentration) {
			exceptionMustBeThrown = true;
		}

		if (exceptionMustBeThrown)
			throw new WarriorIllegalSkillPoints();
	}

}
