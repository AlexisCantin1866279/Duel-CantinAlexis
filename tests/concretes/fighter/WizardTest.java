package concretes.fighter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import exceptions.fighter.WizardIllegalSkillPoints;
import mocks.FireBallStub;
import mocks.HealingSpellStub;
import mocks.WeaponDummy;

public class WizardTest {

	public static final int WIZARD_STRENGTH = 3;
	public static final int WIZARD_DEXTERITY = 8;
	public static final int WIZARD_INTELLIGENCE = 25;
	public static final int WIZARD_CONCENTRATION = 25;

	private IFighter wizardOffensive;
	private IFighter wizardHealing;

	private List<IWeapon> capacitiesList;
	private IWeapon weaponDummy;
	private IWeapon fireBallStub;
	private IWeapon healingSpellStub;

	@Before
	public void initializeWarrior() {

		weaponDummy = new WeaponDummy();
		fireBallStub = new FireBallStub();
		healingSpellStub = new HealingSpellStub();

		capacitiesList = new ArrayList<IWeapon>();
		capacitiesList.add(weaponDummy);
		capacitiesList.add(fireBallStub);
		capacitiesList.add(healingSpellStub);

		wizardOffensive = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, WIZARD_DEXTERITY, WIZARD_INTELLIGENCE,
				WIZARD_CONCENTRATION, capacitiesList);
		wizardHealing = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, WIZARD_DEXTERITY, WIZARD_INTELLIGENCE,
				WIZARD_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveIntelligence() {
		int illegalStrength = WIZARD_INTELLIGENCE + 1;

		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, illegalStrength, WIZARD_DEXTERITY,
				WIZARD_INTELLIGENCE, WIZARD_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveIntelligence() {
		int illegalDexterity = WIZARD_INTELLIGENCE + 1;

		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, illegalDexterity,
				WIZARD_INTELLIGENCE, WIZARD_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WizardIllegalSkillPoints.class)
	public void WHEN_StrenthIsAboveConcentration() {
		int illegalStrength = WIZARD_CONCENTRATION + 1;
		int adaptionintelligence = illegalStrength + Wizard.WIZARD_DELTA_SILLS;

		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, illegalStrength, WIZARD_DEXTERITY,
				adaptionintelligence, WIZARD_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WizardIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveConcentration() {
		int illegalDexterity = WIZARD_CONCENTRATION + 1;
		int adaptionintelligence = illegalDexterity + Wizard.WIZARD_DELTA_SILLS;

		@SuppressWarnings("unused")
		IFighter athleteException = new Wizard(FighterTest.ANY_NAME, WIZARD_STRENGTH, illegalDexterity,
				adaptionintelligence, WIZARD_CONCENTRATION, capacitiesList);
	}

	@Test
	public void GIVEN_wizard_fireBall_WHEN_wizardAttackWithHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = wizardOffensive.getPower(capacitiesList.get(1));

		assertEquals(WIZARD_INTELLIGENCE * Wizard.WIZARD_DELTA_SILLS, attackValue);
	}

	@Test
	public void GIVEN_wizard_healingSpell_WHEN_wizardAttackWithHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = wizardHealing.getPower(capacitiesList.get(2));

		assertEquals(WIZARD_INTELLIGENCE, attackValue);
	}

}
