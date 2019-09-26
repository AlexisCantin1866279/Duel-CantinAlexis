package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import exceptions.fighter.WizardIllegalSkillPoints;

public class WizardTest {

	public static final String ANY_NAME = "Bob";
	public static final int ANY_STRENGTH = 15;
	public static final int ANY_DEXTERITY = 15;
	public static final int ANY_INTELLIGENCE = 30;
	public static final int ANY_CONCENTRATION = 30;
	
	private IFighter wizard;

	@Before
	public void initializeWarrior() {
		wizard = new Wizard(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisStrengthIsInitialize() {
		int strength = wizard.getStrength();
		
		assertEquals(ANY_STRENGTH, strength);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveIntelligence() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(ANY_NAME, ANY_INTELLIGENCE + 1, 0, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveIntelligence() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(ANY_NAME, 0, ANY_INTELLIGENCE + 1, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveConcentration() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(ANY_NAME, ANY_CONCENTRATION + 1, 0, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveConcentration() {
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(ANY_NAME, 0, ANY_CONCENTRATION + 1, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}

}