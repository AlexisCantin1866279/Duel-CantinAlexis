package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import exceptions.fighter.AthleteIllegalSkillPoints;
import mocks.HealingPotionStub;
import mocks.WeaponDummy;

public class AthleteTest {

	public static final int ATHLETE_STRENGTH = 20;
	public static final int ATHLETE_DEXTERITY = 20;
	public static final int ATHLETE_INTELLIGENCE = 20;
	public static final int ATHLETE_CONCENTRATION = 20;

	private IFighter athlete;

	private IWeapon weaponDummy;

	@Before
	public void initializeWarrior() {
		weaponDummy = new WeaponDummy();
		IWeapon healingPotion = new HealingPotionStub();
		athlete = new Athlete(FighterTest.ANY_NAME, ATHLETE_STRENGTH, ATHLETE_DEXTERITY, ATHLETE_INTELLIGENCE,
				ATHLETE_CONCENTRATION, healingPotion);
	}

	@Test(expected = AthleteIllegalSkillPoints.class)
	public void WHEN_StrenthIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(FighterTest.ANY_NAME, Athlete.ATHLETE_DELTA_SKILLS - 1,
				ATHLETE_DEXTERITY, ATHLETE_INTELLIGENCE, ATHLETE_CONCENTRATION, weaponDummy);
	}

	@Test(expected = AthleteIllegalSkillPoints.class)
	public void WHEN_DexterityIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(FighterTest.ANY_NAME, ATHLETE_STRENGTH,
				Athlete.ATHLETE_DELTA_SKILLS - 1, ATHLETE_INTELLIGENCE, ATHLETE_CONCENTRATION, weaponDummy);
	}

	@Test(expected = AthleteIllegalSkillPoints.class)
	public void WHEN_IntelligenceIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(FighterTest.ANY_NAME, ATHLETE_STRENGTH, ATHLETE_DEXTERITY,
				Athlete.ATHLETE_DELTA_SKILLS - 1, ATHLETE_CONCENTRATION, weaponDummy);
	}

	@Test(expected = AthleteIllegalSkillPoints.class)
	public void WHEN_ConcentrationIsUnderAthleteSkillsCap() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Athlete(FighterTest.ANY_NAME, ATHLETE_STRENGTH, ATHLETE_DEXTERITY,
				ATHLETE_INTELLIGENCE, Athlete.ATHLETE_DELTA_SKILLS - 1, weaponDummy);
	}

	@Test
	public void GIVEN_athlete_healingPotion_WHEN_athleteHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = athlete.attack();

		assertEquals(ATHLETE_DEXTERITY, attackValue);
	}

}
