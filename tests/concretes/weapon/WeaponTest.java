package concretes.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;
import abstracts.weapon.IWeapon.weaponType;
import exceptions.weapon.IllegalWeaponPower;
import mocks.FighterStub;

public class WeaponTest {
	
	public static final int ANY_POWER = 20;
	
	IWeapon sword;
	
	IFighter fighterStub;
	
	@Before
	public void initialiseWeapon() {
		sword = new Sword(ANY_POWER, weaponType.PHYSICAL);
		
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
	public void WHEN_AttackIsCalled_THEN_TheValueOfTheAttackIsReturned() {
		int attackValue = sword.attack(fighterStub);
		
		assertEquals(4, attackValue);
	}

}
