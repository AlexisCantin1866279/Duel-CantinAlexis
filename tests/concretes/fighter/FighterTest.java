package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import abstracts.weapon.IWeapon.weaponType;
import exceptions.fighter.IllegalSkillPoints;
import mocks.FireBallStub;
import mocks.WeaponDummy;

public class FighterTest {

	public static final String ANY_NAME = "Bob";

	private IFighter warrior;
	private IFighter athlete;
	private IFighter wizard;
	private IFighter magicWarrior;

	private IWeapon weaponDummy;
	private IWeapon fireBallStub;

	@Before
	public void initilizeFighter() {
		weaponDummy = new WeaponDummy();
		fireBallStub = new FireBallStub();
		warrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, weaponDummy);
		athlete = new Athlete(ANY_NAME, AthleteTest.ATHLETE_STRENGTH, AthleteTest.ATHLETE_DEXTERITY,
				AthleteTest.ATHLETE_INTELLIGENCE, AthleteTest.ATHLETE_CONCENTRATION, weaponDummy);
		wizard = new Wizard(ANY_NAME, WizardTest.WIZARD_STRENGTH, WizardTest.WIZARD_DEXTERITY,
				WizardTest.WIZARD_INTELLIGENCE, WizardTest.WIZARD_CONCENTRATION, weaponDummy);
		magicWarrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, fireBallStub);
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
	
	@Test
	public void WHEN_FighterIsInitialise_THEN_HisWeaponHaveAType() {
		
		weaponType type = magicWarrior.getWeaponType();

		final weaponType EXPECTED_TYPE = weaponType.ATTACK;
		assertEquals(EXPECTED_TYPE, type);
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

}
