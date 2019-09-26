package concretes.fighter;

import exceptions.fighter.AthleteIllegalSkillPoints;

public class Athlete extends Fighter {
	
	public static final int ATHLETE_SKILLS_CAP = 20;

	public Athlete(String name, int strength, int dexterity, int intelligence, int concentration) {
		super(name, strength, dexterity, intelligence, concentration);
		validateAthleteSkills(strength, dexterity, intelligence, concentration);
	}

	private void validateAthleteSkills(int strength, int dexterity, int intelligence, int concentration) {

		boolean exceptionMustBeThrown = false;
		
		if (strength < ATHLETE_SKILLS_CAP) {
			exceptionMustBeThrown = true;
		} else if (dexterity < ATHLETE_SKILLS_CAP) {
			exceptionMustBeThrown = true;
		} else if (intelligence < ATHLETE_SKILLS_CAP) {
			exceptionMustBeThrown = true;
		} else if (concentration < ATHLETE_SKILLS_CAP) {
			exceptionMustBeThrown = true;
		}

		if (exceptionMustBeThrown)
			throw new AthleteIllegalSkillPoints();
	}

}
