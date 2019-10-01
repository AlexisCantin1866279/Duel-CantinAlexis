package concretes.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import concretes.strategy.MagicCapacity;
import exceptions.weapon.IllegalWeaponPower;
import mocks.FighterStub;

public class WeaponTest {
	
	public static final int ANY_POWER = 20;
	
	IWeapon sword;
	IWeapon shield;
	IWeapon fireBall;
	IWeapon healingSpell;
	IWeapon healingPotion;
	
	IFighter fighterStub;
	
	@Before
	public void initialiseWeapon() {
		sword = new Sword(ANY_POWER);
		shield = new Shield(ANY_POWER);
		fireBall = new FireBall(ANY_POWER);
		healingSpell = new HealingSpell(ANY_POWER);
		healingPotion = new HealingPotion(ANY_POWER);
		
		fighterStub = new FighterStub();
	}

	@Test
	public void WHEN_PowerIsAskedOnWeapon_THEN_ThePowerOfItIsReturn() {
		int power = sword.getPower();
		
		assertEquals(ANY_POWER, power);
	}
	
	@Test (expected = IllegalWeaponPower.class)
	public void WHEN_TooLowPowerIsSet() {
		
		@SuppressWarnings("unused")
		IWeapon illegalSword = new Sword(Weapon.MIN_POWER - 1);
	}
	
	@Test (expected = IllegalWeaponPower.class)
	public void WHEN_TooHighPowerIsSet() {
		
		@SuppressWarnings("unused")
		IWeapon illegalSword = new Sword(Weapon.MAX_POWER + 1);
	}
	
	@Test
	public void GIVEN_Sword_WHEN_CapacityPowerIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = sword.getCapacityPower(fighterStub);
		
		final int EXPECTED = fighterStub.getStrength() * sword.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_Shield_WHEN_CapacityPowerIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = shield.getCapacityPower(fighterStub);
		
		final int EXPECTED = fighterStub.getStrength() * shield.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_FireBall_WHEN_CapacityPowerIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = fireBall.getCapacityPower(fighterStub);
		
		final int EXPECTED = (fighterStub.getIntelligence() * fireBall.getPower() / 100) * MagicCapacity.MAGIC_EFFECT;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_HealingSpell_WHEN_CapacityPowerIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = healingSpell.getCapacityPower(fighterStub);
		
		final int EXPECTED = fighterStub.getIntelligence() * fireBall.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_HealingPotion_WHEN_CapacityPowerIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = healingPotion.getCapacityPower(fighterStub);
		
		final int EXPECTED = fighterStub.getDexterity() * healingPotion.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
}
