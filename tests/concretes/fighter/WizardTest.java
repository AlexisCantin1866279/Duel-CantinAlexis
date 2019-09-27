package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import exceptions.fighter.WizardIllegalSkillPoints;
import mocks.WeaponDummy;

public class WizardTest {

	public static final int WIZARD_STRENGTH = 3;
	public static final int WIZARD_DEXTERITY = 8;
	public static final int WIZARD_INTELLIGENCE = 25;
	public static final int WIZARD_CONCENTRATION = 25;
	
	private IFighter wizard;
	private IWeapon weaponDummy;

	@Before
	public void initializeWarrior() {
		weaponDummy = new WeaponDummy();
		wizard = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, WIZARD_DEXTERITY, WIZARD_INTELLIGENCE, WIZARD_CONCENTRATION, weaponDummy);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveIntelligence() {
		int illegalStrength = WIZARD_INTELLIGENCE + 1;
		
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, illegalStrength, WIZARD_DEXTERITY, WIZARD_INTELLIGENCE, WIZARD_CONCENTRATION, weaponDummy);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveIntelligence() {
		int illegalDexterity = WIZARD_INTELLIGENCE + 1;
		
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, illegalDexterity, WIZARD_INTELLIGENCE, WIZARD_CONCENTRATION, weaponDummy);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveConcentration() {
		int illegalStrength = WIZARD_CONCENTRATION + 1;
		int adaptionintelligence = illegalStrength + Wizard.WIZARD_DELTA_SILLS;
		
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, illegalStrength, WIZARD_DEXTERITY, adaptionintelligence, WIZARD_CONCENTRATION, weaponDummy);
	}
	
	@Test (expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveConcentration() {
		int illegalDexterity = WIZARD_CONCENTRATION + 1;
		int adaptionintelligence = illegalDexterity + Wizard.WIZARD_DELTA_SILLS;
		
		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, illegalDexterity, adaptionintelligence, WIZARD_CONCENTRATION, weaponDummy);
	}

}
