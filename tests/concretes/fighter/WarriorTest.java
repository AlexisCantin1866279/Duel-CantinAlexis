package concretes.fighter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import exceptions.fighter.IllegalSkillPoints;
import exceptions.fighter.WarriorIllegalSkillPoints;

public class WarriorTest {

	public static final String ANY_NAME = "Bob";
	public static final int ANY_STRENGTH = 40;
	public static final int ANY_DEXTERITY = 30;
	public static final int ANY_INTELLIGENCE = 20;
	public static final int ANY_CONCENTRATION = 10;
	
	private IFighter warrior;

	@Before
	public void initializeWarrior() {
		 warrior = new Warrior(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
	// Method tests for all Fighter
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisStrengthIsInitialize() {
		int strength = warrior.getStrength();
		
		assertEquals(ANY_STRENGTH, strength);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisNameIsInitialize() {
		String name = warrior.getName();
		
		assertEquals(ANY_NAME, name);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisDexterityIsInitialize() {
		int dexterity = warrior.getDexterity();
		
		assertEquals(ANY_DEXTERITY, dexterity);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisIntelligenceIsInitialize() {
		int intelligence = warrior.getIntelligence();
		
		assertEquals(ANY_INTELLIGENCE, intelligence);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisConcentrationhIsInitialize() {
		int concentration = warrior.getConcentration();
		
		assertEquals(ANY_CONCENTRATION, concentration);
	}
	
	@Test
	public void WHEN_FighterIsCreated_THEN_HisLifeHpIsInitialize() {
		int life = warrior.getLifePoint();
		
		final int EXPECTED_LIFE = Fighter.BASE_HP - (ANY_STRENGTH + ANY_DEXTERITY + ANY_INTELLIGENCE + ANY_CONCENTRATION);
		assertEquals(EXPECTED_LIFE, life);
	}
	
	@Test (expected = IllegalSkillPoints.class)
	public void WHEN_StrengthIsAboveMax() {
		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, Fighter.MAX_SKILLS + 1, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);
	}
	
//	@Test (expected = IllegalSkillPoints.class)
//	public void WHEN_DexterityIsAboveMax() {
//		@SuppressWarnings("unused")
//		IFighter warriorException = new Warrior(ANY_NAME, ANY_STRENGTH, Fighter.MAX_SKILLS + 1, ANY_INTELLIGENCE, ANY_CONCENTRATION);
//	}
//	
//	@Test (expected = IllegalSkillPoints.class)
//	public void WHEN_IntelligenceIsAboveMax() {
//		@SuppressWarnings("unused")
//		IFighter warriorException = new Warrior(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, Fighter.MAX_SKILLS + 1, ANY_CONCENTRATION);
//	}
//	
//	@Test (expected = IllegalSkillPoints.class)
//	public void WHEN_ConcentrationIsAboveMax() {
//		@SuppressWarnings("unused")
//		IFighter warriorException = new Warrior(ANY_NAME, ANY_STRENGTH, ANY_DEXTERITY, ANY_INTELLIGENCE, Fighter.MAX_SKILLS + 1);
//	}
	
	// Method Test for a Warrior
	
	@Test (expected = WarriorIllegalSkillPoints.class)
	public void WHEN_DexterityIsAboveStrength() {
		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, ANY_STRENGTH, ANY_STRENGTH + 1, 0, 0);
	}
	
	@Test (expected = WarriorIllegalSkillPoints.class)
	public void WHEN_IntelligenceIsAboveDexterity() {
		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, ANY_DEXTERITY + 1, ANY_DEXTERITY, ANY_DEXTERITY + 1, 0);
	}
	
	@Test (expected = WarriorIllegalSkillPoints.class)
	public void WHEN_ConcentrationIsAboveIntelligence() {
		@SuppressWarnings("unused")
		IFighter warriorException = new Warrior(ANY_NAME, ANY_INTELLIGENCE, ANY_CONCENTRATION, ANY_CONCENTRATION, ANY_INTELLIGENCE + 1);
	}

}
