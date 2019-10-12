package concretes.fighter;

import java.util.List;

import abstracts.weapon.IWeapon;
import exceptions.fighter.AthleteIllegalSkillPoints;

/**
 * Classe permettant d'implementer un combattant athlete
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class Athlete extends Fighter {

	public static final int ATHLETE_DELTA_SKILLS = 20;

	public Athlete(String name, int strength, int dexterity, int intelligence, int concentration,
			List<IWeapon> capacityList) {
		super(name, strength, dexterity, intelligence, concentration, capacityList);
		validateAthleteSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateAthleteSkills(int strength, int dexterity, int intelligence, int concentration) {

		boolean exceptionMustBeThrown = false;

		if (strength < ATHLETE_DELTA_SKILLS) {
			exceptionMustBeThrown = true;//MS Pourquoi ne pas faire le throw directement ici? L'exécution du code s'arrêtera.
		} else if (dexterity < ATHLETE_DELTA_SKILLS) {
			exceptionMustBeThrown = true;
		} else if (intelligence < ATHLETE_DELTA_SKILLS) {
			exceptionMustBeThrown = true;
		} else if (concentration < ATHLETE_DELTA_SKILLS) {
			exceptionMustBeThrown = true;
		}

		if (exceptionMustBeThrown)
			throw new AthleteIllegalSkillPoints();
	}

}
