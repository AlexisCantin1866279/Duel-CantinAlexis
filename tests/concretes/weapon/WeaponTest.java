package concretes.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import abstracts.weapon.IWeapon.weaponType;
import concretes.strategy.MagicCapacity;
import exceptions.weapon.IllegalWeaponPower;
import mocks.FighterStub;

public class WeaponTest {
	
	public static final int ANY_POWER = 20;
	
	IWeapon sword;
	IWeapon fireBall;
	IWeapon healingSpell;
	IWeapon healingPotion;
	
	IFighter fighterStub;
	
	@Before
	public void initialiseWeapon() {
		sword = new Sword(ANY_POWER, weaponType.PHYSICAL);
		fireBall = new FireBall(ANY_POWER, weaponType.MAGIC);
		healingSpell = new HealingSpell(ANY_POWER, weaponType.HEAL);
		healingPotion = new HealingPotion(ANY_POWER, weaponType.POTION);
		
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
		IWeapon illegalSword = new Sword(Weapon.MIN_POWER - 1, weaponType.PHYSICAL);
	}
	
	@Test (expected = IllegalWeaponPower.class)
	public void WHEN_TooHighPowerIsSet() {
		
		@SuppressWarnings("unused")
		IWeapon illegalSword = new Sword(Weapon.MAX_POWER + 1, weaponType.PHYSICAL);
	}
	
	@Test
	public void GIVEN_Sword_WHEN_AttackIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = sword.attack(fighterStub);
		
		final int EXPECTED = fighterStub.getStrength() * sword.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_FireBall_WHEN_AttackIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = fireBall.attack(fighterStub);
		
		final int EXPECTED = (fighterStub.getIntelligence() * fireBall.getPower() / 100) * MagicCapacity.MAGIC_EFFECT;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_HealingSpell_WHEN_AttackIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = healingSpell.attack(fighterStub);
		
		final int EXPECTED = fighterStub.getIntelligence() * healingSpell.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}
	
	@Test
	public void GIVEN_HealingPotion_WHEN_AttackIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = healingPotion.attack(fighterStub);
		
		final int EXPECTED = fighterStub.getDexterity() * healingPotion.getPower() / 100;
		assertEquals(EXPECTED, attackValue);
	}

}
