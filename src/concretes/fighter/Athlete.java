package concretes.fighter;

import exceptions.fighter.AthleteIllegalSkillPoints;

public class Athlete extends Fighter {
	
	public static final int ATHLETE_DELTA_SKILLS = 20;

	public Athlete(String name, int strength, int dexterity, int intelligence, int concentration) {
		super(name, strength, dexterity, intelligence, concentration);
		validateAthleteSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateAthleteSkills(int strength, int dexterity, int intelligence, int concentration) {

		boolean exceptionMustBeThrown = false;
		
		if (strength < ATHLETE_DELTA_SKILLS) {
			exceptionMustBeThrown = true;
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
