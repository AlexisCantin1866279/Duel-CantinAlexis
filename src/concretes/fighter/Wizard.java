package concretes.fighter;

import abstracts.weapon.IWeapon;
import exceptions.fighter.WizardIllegalSkillPoints;

public class Wizard extends Fighter {

	public static final int WIZARD_DELTA_SILLS = 15;

	public Wizard(String name, int strength, int dexterity, int intelligence, int concentration, IWeapon weapon) {
		super(name, strength, dexterity, intelligence, concentration, weapon);
		validateWizardSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateWizardSkills(int strength, int dexterity, int intelligence, int concentration) {
		boolean exceptionMustBeTrown = false;

		if (intelligence < (Math.max(strength, dexterity)) + WIZARD_DELTA_SILLS) {
			exceptionMustBeTrown = true;
		} else if (concentration < (Math.max(strength, dexterity)) + WIZARD_DELTA_SILLS) {
			exceptionMustBeTrown = true;
		}

		if (exceptionMustBeTrown)
			throw new WizardIllegalSkillPoints();
	}

}
