package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import exceptions.fighter.AthleteIllegalSkillPoints;

public class AthleteTest {

	public static final String ANY_NAME = "Bob";
	public static final int ANY_STRENGTH = 20;
	public static final int ANY_DEXTERITY = 20;
	public static final int ANY_INTELLIGENCE = 20;
	public static final int ANY_CONCENTRATION = 20;
	
	private IFighter athlete;

	@Before
	public void initializeWarrior() {
		athlete = new Athlete(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisStrengthIsInitialize() {
		int strength = athlete.getStrength();
		
		assertEquals(ANY_STRENGTH, strength);
	}
	
	@Test (expected = AthleteIllegalSkillPoints.class)
	public void WHEN_StrenthIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(ANY_NAME, Athlete.ATHLETE_SKILLS_CAP -1, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test (expected = AthleteIllegalSkillPoints.class)
	public void WHEN_DexterityIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(ANY_NAME, ANY_STRENGTH, Athlete.ATHLETE_SKILLS_CAP -1, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test (expected = AthleteIllegalSkillPoints.class)
	public void WHEN_IntelligenceIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, Athlete.ATHLETE_SKILLS_CAP -1, ANY_CONCENTRATION);
	}
	
	@Test (expected = AthleteIllegalSkillPoints.class)
	public void WHEN_ConcentrationIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, ANY_INTELLIGENCE, Athlete.ATHLETE_SKILLS_CAP -1);
	}

}
