package concretes.fighter;

import exceptions.fighter.WarriorIllegalSkillPoints;

public class Warrior extends Fighter {

	public static final int WARRIOR_SKILLS_CAP = 10;

	public Warrior(String name, int strength, int dexterity, int intelligence, int concentration) {
		super(name, strength, dexterity, intelligence, concentration);
		validateWarriorSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateWarriorSkills(int strength, int dexterity, int intelligence, int concentration) {
		int dexterityDifference = dexterity + WARRIOR_SKILLS_CAP;
		int intelligenceDifference = intelligence + WARRIOR_SKILLS_CAP;
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
