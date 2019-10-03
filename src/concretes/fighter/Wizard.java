package concretes.fighter;

import java.util.List;

import abstracts.weapon.IWeapon;
import exceptions.fighter.WizardIllegalSkillPoints;

/**
 * Classe permettant d'implementer un combattant magicien
 * 
 * @author Alexis
 * @version Octobre 2019
 */
public class Wizard extends Fighter {

	public static final int WIZARD_DELTA_SILLS = 15;

	public Wizard(String name, int strength, int dexterity, int intelligence, int concentration,
			List<IWeapon> capacityList) {
		super(name, strength, dexterity, intelligence, concentration, capacityList);
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
