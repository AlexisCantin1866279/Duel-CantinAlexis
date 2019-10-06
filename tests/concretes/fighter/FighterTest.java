package concretes.fighter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;
import concretes.duel.Duel;
import exceptions.fighter.CapacityExistenceException;
import exceptions.fighter.IllegalFightException;
import exceptions.fighter.IllegalNumberCapacitiesStart;
import exceptions.fighter.IllegalSkillPoints;
import exceptions.fighter.ToManyWeaponException;
import mocks.FighterSpy;
import mocks.FireBallStub;
import mocks.HealingSpellStub;
import mocks.ShieldStub;
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

	private List<IWeapon> capacitiesListDummy;
	private List<IWeapon> capacitiesListMagicWarrior;
	private List<IWeapon> capacitiesListHealingWizard;
	private List<IWeapon> capacitiesListFightingAthlete;
	private IWeapon weaponDummy;
	private IWeapon fireBallStub;
	private IWeapon healingSpellStub;
	private IWeapon swordStub;
	private IWeapon shieldStub;

	@Before
	public void initilizeFighter() {

		weaponDummy = new WeaponDummy();
		fireBallStub = new FireBallStub();
		healingSpellStub = new HealingSpellStub();
		swordStub = new SwordStub();
		fighterSpy = new FighterSpy();
		shieldStub = new ShieldStub();

		capacitiesListDummy = new ArrayList<IWeapon>();
		capacitiesListDummy.add(weaponDummy);
		capacitiesListDummy.add(weaponDummy);

		capacitiesListMagicWarrior = new ArrayList<IWeapon>();
		capacitiesListMagicWarrior.add(fireBallStub);
		capacitiesListMagicWarrior.add(swordStub);

		capacitiesListHealingWizard = new ArrayList<IWeapon>();
		capacitiesListHealingWizard.add(healingSpellStub);
		capacitiesListHealingWizard.add(shieldStub);

		capacitiesListFightingAthlete = new ArrayList<IWeapon>();
		capacitiesListFightingAthlete.add(swordStub);
		capacitiesListFightingAthlete.add(shieldStub);

		warrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, capacitiesListDummy);
		athlete = new Athlete(ANY_NAME, AthleteTest.ATHLETE_STRENGTH, AthleteTest.ATHLETE_DEXTERITY,
				AthleteTest.ATHLETE_INTELLIGENCE, AthleteTest.ATHLETE_CONCENTRATION, capacitiesListDummy);
		wizard = new Wizard(ANY_NAME, WizardTest.WIZARD_STRENGTH, WizardTest.WIZARD_DEXTERITY,
				WizardTest.WIZARD_INTELLIGENCE, WizardTest.WIZARD_CONCENTRATION, capacitiesListDummy);
		magicWarrior = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, capacitiesListMagicWarrior);
		healingWizard = new Wizard(ANY_NAME, WizardTest.WIZARD_STRENGTH, WizardTest.WIZARD_DEXTERITY,
				WizardTest.WIZARD_INTELLIGENCE, WizardTest.WIZARD_CONCENTRATION, capacitiesListHealingWizard);
		fightingAthlete = new Athlete(ANY_NAME, AthleteTest.ATHLETE_STRENGTH, AthleteTest.ATHLETE_DEXTERITY,
				AthleteTest.ATHLETE_INTELLIGENCE, AthleteTest.ATHLETE_CONCENTRATION, capacitiesListFightingAthlete);
	}

	// test d'initialisation d'un combattant
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
	public void WHEN_FighterIsCreated_THEN_HisConcentrationIsInitialize() {
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
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, capacitiesListDummy);
	}

	@Test(expected = IllegalNumberCapacitiesStart.class)
	public void WHEN_FighterInitiliseWithOneCapacities() {

		List<IWeapon> illegalList = new ArrayList<IWeapon>();
		illegalList.add(weaponDummy);

		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, WarriorTest.WARRIOR_STRENGTH, WarriorTest.WARRIOR_DEXTERITY,
				WarriorTest.WARRIOR_INTELLIGENCE, WarriorTest.WARRIOR_CONCENTRATION, illegalList);
	}

	// test de la methode power
	@Test
	public void GIVEN_warrior_fireBall_WHEN_warriorAttackWithHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = magicWarrior.getPower(capacitiesListMagicWarrior.get(0));

		assertEquals(WizardTest.WIZARD_INTELLIGENCE * Wizard.WIZARD_DELTA_SILLS, attackValue);
	}

	// test de la capacite au combattant de se soigner
	@Test
	public void WHEN_FighterHaveHealingCapacity_THEN_HeCanGoToTheInfirmary() {

		int life = healingWizard.getInitialLifePoint() / 2;
		healingWizard.setLifePoint(life);
		healingWizard.nurse((IHealing) capacitiesListHealingWizard.get(0));

		final int EXPECTED = life + WizardTest.WIZARD_INTELLIGENCE;
		assertEquals(EXPECTED, healingWizard.getLifePoint());
	}

	@Test
	public void WHEN_FighterHaveBeenToTheInfirmary_THEN_HisHealingCapacityIsDetroy() {

		fighterSpy.nurse((IHealing) capacitiesListHealingWizard.get(0));

		assertEquals(true, fighterSpy.destroyWeaponHasBeenCalled);
	}

	// test de la capacite a un combattant de faire un duel et de gagner
	@Test
	public void WHEN_FighterWinFight_THEN_HisStrengthIncrease() {

		int initialStrength = magicWarrior.getStrength();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialStrength + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getStrength());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisDexterityIncrease() {

		int initialDexterity = magicWarrior.getDexterity();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialDexterity + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getDexterity());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisIntelligenceIncrease() {

		int initialIntelligence = magicWarrior.getIntelligence();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialIntelligence + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getIntelligence());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisConcentrationIncrease() {

		int initialConcentration = magicWarrior.getConcentration();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialConcentration + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getConcentration());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLooseHp() {

		int initialLifePoint = fightingAthlete.getLifePoint();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialLifePoint - (magicWarrior.getPower(capacitiesListMagicWarrior.get(0))
				- fightingAthlete.getPower(capacitiesListFightingAthlete.get(0)));
		assertEquals(EXPECTED, fightingAthlete.getLifePoint());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseStrength() {

		int initialStrength = fightingAthlete.getStrength();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialStrength - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getStrength());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseDexterity() {

		int initialDexterity = fightingAthlete.getDexterity();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialDexterity - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getDexterity());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseIntelligence() {

		int initialIntelligence = fightingAthlete.getIntelligence();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialIntelligence - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getIntelligence());
	}

	@Test
	public void WHEN_FighterWinFight_THEN_HisOpposantLoseConcentration() {

		int initialConcentration = fightingAthlete.getConcentration();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));

		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}

	// test de la capacite a un combattant de faire un duel et de gagner
	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantStrengthIncrease() {

		int initialStrength = magicWarrior.getStrength();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialStrength + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getStrength());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantDexterityIncrease() {

		int initialDexterity = magicWarrior.getDexterity();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialDexterity + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getDexterity());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantIntelligenceIncrease() {

		int initialIntelligence = magicWarrior.getIntelligence();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialIntelligence + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getIntelligence());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpponantConcentrationIncrease() {

		int initialConcentration = magicWarrior.getConcentration();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialConcentration + Duel.REWARD_DELTA;
		assertEquals(EXPECTED, magicWarrior.getConcentration());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HeLosesHp() {

		int initialLifePoint = fightingAthlete.getLifePoint();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialLifePoint - (magicWarrior.getPower(capacitiesListMagicWarrior.get(0))
				- fightingAthlete.getPower(capacitiesListFightingAthlete.get(0)));
		assertEquals(EXPECTED, fightingAthlete.getLifePoint());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantStrengthDecrease() {

		int initialStrength = fightingAthlete.getStrength();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialStrength - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getStrength());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisOpposantDexterityDecrease() {

		int initialDexterity = fightingAthlete.getDexterity();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialDexterity - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getDexterity());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HistIntelligenceDecrease() {

		int initialIntelligence = fightingAthlete.getIntelligence();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialIntelligence - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getIntelligence());
	}

	@Test
	public void WHEN_FighterLoseFight_THEN_HisConcentrationDecrease() {

		int initialConcentration = fightingAthlete.getConcentration();

		fightingAthlete.provoke(magicWarrior, (IAttack) swordStub);
		magicWarrior.hitBack((IAttack) capacitiesListMagicWarrior.get(0));

		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}

	// test de la capacite a un combattant d'abandonner un duel
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

	@Test
	public void WHEN_DefenderHaveShield_THEN_HeCanDefendHimself() {

		int initialConcentration = fightingAthlete.getConcentration();

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IParade) capacitiesListFightingAthlete.get(1));

		final int EXPECTED = initialConcentration - Duel.REWARD_DELTA;
		assertEquals(EXPECTED, fightingAthlete.getConcentration());
	}

	// robusttesse de combattant qui se bat tout seul
	@Test(expected = IllegalFightException.class)
	public void WHEN_FighterWantToHitBackWithAttackWeaponButHeDoesntChallenged() {

		fightingAthlete.hitBack((IAttack) capacitiesListFightingAthlete.get(0));
	}

	@Test(expected = IllegalFightException.class)
	public void WHEN_FighterWantToHitBackWithParadeWeaponButHeDoesntChallenged() {

		IWeapon shieldStub = new ShieldStub();
		capacitiesListFightingAthlete.add(shieldStub);

		fightingAthlete.hitBack((IParade) capacitiesListFightingAthlete.get(2));
	}

	@Test(expected = IllegalFightException.class)
	public void WHEN_FighterWantToSurrenderButHeDoesntChallenged() {

		fightingAthlete.surrender();
	}
	
	// test de la validiter de l'arme
	@Test(expected = CapacityExistenceException.class)
	public void WHEN_FighterWantToUseAnOtherWeaponToProvoke() {

		warrior.provoke(athlete, (IAttack) fireBallStub);
	}
	
	@Test(expected = CapacityExistenceException.class)
	public void WHEN_FighterWantToUseAnOtherWeaponToHeal() {

		warrior.nurse((IHealing) healingSpellStub);
	}
	
	@Test(expected = CapacityExistenceException.class)
	public void WHEN_FighterWantToUseAnOtherAttackWeaponToHitBack() {

		magicWarrior.provoke(warrior, (IAttack) fireBallStub);
		warrior.hitBack((IAttack) fireBallStub);
	}
	
	@Test(expected = CapacityExistenceException.class)
	public void WHEN_FighterWantToUseAnOtherParadeWeaponToHitBack() {

		magicWarrior.provoke(warrior, (IAttack) fireBallStub);
		warrior.hitBack((IParade) shieldStub);
	}

	// test de la methode addWeapon
	@Test(expected = ToManyWeaponException.class)
	public void WHEN_FighterWantToAddWeaponButHeDoesntHaveWinADuel() {

		warrior.addWeapon(weaponDummy);
	}
	
	@Test
	public void WHEN_FighterWantToAddWeapon_THEN_TheWeaponIsAdded() {

		magicWarrior.provoke(fightingAthlete, (IAttack) fireBallStub);
		fightingAthlete.hitBack((IAttack) swordStub);
		
		magicWarrior.addWeapon(healingSpellStub);
		magicWarrior.nurse((IHealing) healingSpellStub);
		
		// si l'arme n'a pas ete ajouter, une exception aurait ete lance
		assertTrue(true);
	}

}
