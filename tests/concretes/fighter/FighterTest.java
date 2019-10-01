package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import exceptions.fighter.IllegalSkillPoints;
import mocks.FighterSpy;
import mocks.FireBallStub;
import mocks.HealingSpellStub;
import mocks.WeaponDummy;

public class FighterTest {

	public static final String ANY_NAME = "Bob";

	private IFighter warrior;
	private IFighter athlete;
	private IFighter wizard;
	private IFighter magicWarrior;
	private IFighter healingWizard;
	
	private FighterSpy fighterSpy;

	private IWeapon weaponDummy;
	private IWeapon fireBallStub;
	private IWeapon healingSpellStub;

	@Before
	public void initilizeFighter() {
		weaponDummy = new WeaponDummy();
		fireBallStub = new FireBallStub();
		healingSpellStub = new HealingSpellStub();
		fighterSpy = new FighterSpy();
		
		warrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, weaponDummy);
		athlete = new Athlete(ANY_NAME, AthleteTest.ATHLETE_STRENGTH, AthleteTest.ATHLETE_DEXTERITY,
				AthleteTest.ATHLETE_INTELLIGENCE, AthleteTest.ATHLETE_CONCENTRATION, weaponDummy);
		wizard = new Wizard(ANY_NAME, WizardTest.WIZARD_STRENGTH, WizardTest.WIZARD_DEXTERITY,
				WizardTest.WIZARD_INTELLIGENCE, WizardTest.WIZARD_CONCENTRATION, weaponDummy);
		magicWarrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, fireBallStub);
		healingWizard = new Wizard(ANY_NAME, WizardTest.WIZARD_STRENGTH, WizardTest.WIZARD_DEXTERITY,
				WizardTest.WIZARD_INTELLIGENCE, WizardTest.WIZARD_CONCENTRATION, healingSpellStub);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisStrengthIsInitialize() {
		int strength = warrior.getStrength();

		assertEquals(WarriorTest.WARRIOR_STRENGTH, strength);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisNameIsInitialize() {
		String name = athlete.getName();

		assertEquals(ANY_NAME, name);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisDexterityIsInitialize() {
		int dexterity = wizard.getDexterity();

		assertEquals(WizardTest.WIZARD_DEXTERITY, dexterity);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisIntelligenceIsInitialize() {
		int intelligence = warrior.getIntelligence();

		assertEquals(WarriorTest.WARRIOR_INTELLIGENCE, intelligence);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisConcentrationhIsInitialize() {
		int concentration = athlete.getConcentration();

		assertEquals(AthleteTest.ATHLETE_CONCENTRATION, concentration);
	}

	@Test
	public void WHEN_FighterIsCreated_THEN_HisLifeHpIsInitialize() {
		int life = wizard.getLifePoint();

		final int EXPECTED_LIFE = Fighter.BASE_HP - (WizardTest.WIZARD_STRENGTH + WizardTest.WIZARD_DEXTERITY
				+ WizardTest.WIZARD_INTELLIGENCE + WizardTest.WIZARD_CONCENTRATION);
		assertEquals(EXPECTED_LIFE, life);
	}
	
	@Test
	public void WHEN_FighterHpChange_THEN_HisLifeHpIsChanged() {
		warrior.setLifePoint(0);
		int life = warrior.getLifePoint();

		final int EXPECTED_LIFE = 0;
		assertEquals(EXPECTED_LIFE, life);
	}
	
	@Test
	public void WHEN_FighterHpChange_THEN_HisInitialLifeHpIsTheSame() {
		
		int initial = athlete.getLifePoint();
		athlete.setLifePoint(0);

		final int EXPECTED_LIFE = athlete.getInitialLifePoint();
		assertEquals(EXPECTED_LIFE, initial);
	}

	@Test(expected = IllegalSkillPoints.class)
	public void WHEN_StrengthIsAboveMax() {
		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, Fighter.MAX_SKILLS + 1, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, weaponDummy);
	}

	@Test
	public void GIVEN_warrior_fireBall_WHEN_warriorAttackWithHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = magicWarrior.getPower();

		assertEquals(WizardTest.WIZARD_INTELLIGENCE * Wizard.WIZARD_DELTA_SILLS, attackValue);
	}
	
	@Test
	public void WHEN_FighterHaveHealingCapacity_THEN_HeCanGoToTheInfirmary() {
		
		int life = healingWizard.getInitialLifePoint() / 2;
		healingWizard.setLifePoint(life);
		healingWizard.nurse();
		
		final int EXPECTED = life + WizardTest.WIZARD_INTELLIGENCE;
		assertEquals(EXPECTED, healingWizard.getLifePoint());
	}
	
	@Test
	public void WHEN_FighterHaveBeenToTheInfirmary_THEN_HisHealingCapacityIsDetroy() {
		
		fighterSpy.nurse();
		
		assertEquals(true, fighterSpy.destroyWeaponHasBeenCalled);
	}

}
