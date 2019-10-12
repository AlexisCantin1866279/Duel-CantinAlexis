package concretes.fighter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import exceptions.fighter.WarriorIllegalSkillPoints;
import mocks.SwordStub;
import mocks.WeaponDummy;

public class WarriorTest {

	public static final int WARRIOR_STRENGTH = 40;
	public static final int WARRIOR_DEXTERITY = 30;
	public static final int WARRIOR_INTELLIGENCE = 20;
	public static final int WARRIOR_CONCENTRATION = 10;

	private IFighter warrior;
	private List<IWeapon> capacitiesList;
	private IWeapon swordStub;
	private IWeapon weaponDummy;

	@Before
	public void initializeWarrior() {
		weaponDummy = new WeaponDummy();
		swordStub = new SwordStub();

		capacitiesList = new ArrayList<IWeapon>();
		capacitiesList.add(weaponDummy);
		capacitiesList.add(swordStub);

		warrior = new Warrior(FighterTest.ANY_NAME, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE,
				WARRIOR_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WarriorIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveStrength() {
		int illegalStrength = WARRIOR_STRENGTH - 1; // 39

		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(FighterTest.ANY_NAME, illegalStrength, WARRIOR_DEXTERITY,
				WARRIOR_INTELLIGENCE, WARRIOR_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WarriorIllegalSkillPoints.class)
	public void WHEN_IntelligenceIsAboveDexterity() {
		int adaptationStrength = WARRIOR_STRENGTH - Warrior.WARRIOR_DELTA_SKILLS; // 30
		int adaptationDexterity = WARRIOR_DEXTERITY - Warrior.WARRIOR_DELTA_SKILLS; // 20
		int illegalIntelligence = WARRIOR_INTELLIGENCE + Warrior.WARRIOR_DELTA_SKILLS + 1; // 31

		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(FighterTest.ANY_NAME, adaptationStrength, adaptationDexterity,
				illegalIntelligence, WARRIOR_CONCENTRATION, capacitiesList);
	}

	@Test(expected = WarriorIllegalSkillPoints.class)
	public void WHEN_ConcentrationIsAboveIntelligence() {
		int adaptationIntelligence = WARRIOR_INTELLIGENCE - Warrior.WARRIOR_DELTA_SKILLS - 2; // 8
		int illegalConcentration = WARRIOR_CONCENTRATION + Warrior.WARRIOR_DELTA_SKILLS + 1; // 21

		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(FighterTest.ANY_NAME, WARRIOR_STRENGTH, WARRIOR_DEXTERITY,
				adaptationIntelligence, illegalConcentration, capacitiesList);
	}

	@Test
	public void GIVEN_warrior_sword_WHEN_warriorAttackWithHisWeapon_THEN_TheCapacityValueIsReturned() {

		int attackValue = warrior.getPower(capacitiesList.get(1));

		assertEquals(WARRIOR_STRENGTH, attackValue);
	}

}
