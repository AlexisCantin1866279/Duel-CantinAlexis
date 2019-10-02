package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;
import concretes.duel.Duel;
import exceptions.fighter.IllegalSkillPoints;
import mocks.FighterSpy;
import mocks.FireBallStub;
import mocks.HealingSpellStub;
import mocks.SwordStub;
import mocks.WeaponDummy;

public class FighterTest {

	public static final String ANY_NAME = "Bob";

	private IFighter warrior;
	private IFighter athlete;
	private IFighter wizard;
	private IFighter magicWarrior;
	private IFighter healingWizard;
	private IFighter fightingAthlete;
	
	private FighterSpy fighterSpy;

	private IWeapon weaponDummy;
	private IWeapon fireBallStub;
	private IWeapon healingSpellStub;
	private IWeapon swordStub;

	@Before
	public void initilizeFighter() {
		weaponDummy = new WeaponDummy();
		fireBallStub = new FireBallStub();
		healingSpellStub = new HealingSpellStub();
		swordStub = new SwordStub();
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
		fightingAthlete = new Athlete(ANY_NAME, AthleteTest.ATHLETE_STRENGTH, AthleteTest.ATHLETE_DEXTERITY,
				AthleteTest.ATHLETE_INTELLIGENCE, AthleteTest.ATHLETE_CONCENTRATION, swordStub);
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
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisStrengthIncrease() {
		
		int initialStrength = magicWarrior.getStrength();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialStrength + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getStrength());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisDexterityIncrease() {
		
		int initialDexterity = magicWarrior.getDexterity();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialDexterity + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getDexterity());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisIntelligenceIncrease() {
		
		int initialIntelligence = magicWarrior.getIntelligence();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialIntelligence + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getIntelligence());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisConcentrationIncrease() {
		
		int initialConcentration = magicWarrior.getConcentration();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialConcentration + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getConcentration());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLooseHp() {
		
		int initialLifePoint = fightingAthlete.getLifePoint();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialLifePoint - (magicWarrior.getPower() - fightingAthlete.getPower());
		assertEquals(EXPECTED, fightingAthlete.getLifePoint());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseStrength() {
		
		int initialStrength = fightingAthlete.getStrength();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialStrength - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getStrength());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseDexterity() {
		
		int initialDexterity = fightingAthlete.getDexterity();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialDexterity - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getDexterity());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseIntelligence() {
		
		int initialIntelligence = fightingAthlete.getIntelligence();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialIntelligence - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getIntelligence());
	}
	
	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseConcentration() {
		
		int initialConcentration = fightingAthlete.getConcentration();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack();
		
		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantStrengthIncrease() {
		
		int initialStrength = magicWarrior.getStrength();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialStrength + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getStrength());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantDexterityIncrease() {
		
		int initialDexterity = magicWarrior.getDexterity();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialDexterity + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getDexterity());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantIntelligenceIncrease() {
		
		int initialIntelligence = magicWarrior.getIntelligence();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialIntelligence + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getIntelligence());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpponantConcentrationIncrease() {
		
		int initialConcentration = magicWarrior.getConcentration();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialConcentration + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getConcentration());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HeLosesHp() {
		
		int initialLifePoint = fightingAthlete.getLifePoint();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialLifePoint - (magicWarrior.getPower() - fightingAthlete.getPower());
		assertEquals(EXPECTED, fightingAthlete.getLifePoint());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantStrengthDecrease() {
		
		int initialStrength = fightingAthlete.getStrength();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialStrength - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getStrength());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantDexterityDecrease() {
		
		int initialDexterity = fightingAthlete.getDexterity();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialDexterity - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getDexterity());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HistIntelligenceDecrease() {
		
		int initialIntelligence = fightingAthlete.getIntelligence();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialIntelligence - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getIntelligence());
	}
	
	@Test
	public void WHEN_FighterLoseFight_THEN_HisConcentrationDecrease() {
		
		int initialConcentration = fightingAthlete.getConcentration();
		
		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack();
		
		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisChallengerStrengthIncrease() {
		
		int initialStrength = magicWarrior.getStrength();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialStrength + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getStrength());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisChallengerDexterityIncrease() {
		
		int initialDexterity = magicWarrior.getDexterity();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialDexterity + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getDexterity());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisIntelligenceChallengerIncrease() {
		
		int initialIntelligence = magicWarrior.getIntelligence();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialIntelligence + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getIntelligence());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisChallengerConcentrationIncrease() {
		
		int initialConcentration = magicWarrior.getConcentration();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialConcentration + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getConcentration());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HeDoesntLooseHp() {
		
		int initialLifePoint = fightingAthlete.getLifePoint();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		assertEquals(initialLifePoint, fightingAthlete.getLifePoint());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisStrengthDecrease() {
		
		int initialStrength = fightingAthlete.getStrength();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialStrength - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getStrength());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisDexterityDecrease() {
		
		int initialDexterity = fightingAthlete.getDexterity();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialDexterity - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getDexterity());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisIntelligenceDecrease() {
		
		int initialIntelligence = fightingAthlete.getIntelligence();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialIntelligence - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getIntelligence());
	}
	
	@Test
	public void WHEN_DefenderSurrender_THEN_HisOpposantLoseConcentrationDecrease() {
		
		int initialConcentration = fightingAthlete.getConcentration();
		
		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.surrender();
		
		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}

}
