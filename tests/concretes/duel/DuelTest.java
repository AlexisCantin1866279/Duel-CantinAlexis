package concretes.duel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;
import mocks.DuelMock;
import mocks.FighterSpy;
import mocks.FighterStub;
import mocks.WeaponDummy;

public class DuelTest {
	
	private DuelMock duelMock;
	private FighterStub attackerStub;
	private FighterSpy defenderSpy;
	private IWeapon weaponDummy;
	
	@Before
	public void prepareDuel() {
		attackerStub = new FighterStub();
		defenderSpy = new FighterSpy();
		weaponDummy = new WeaponDummy();
		duelMock = new DuelMock(attackerStub);
		
	}

	@Test
	public void WHEN_DuelIsInitialise_THEN_TheAttackerIsSet() {
		
		assertEquals(attackerStub, duelMock.attacker);
	}
	
	@Test
	public void WHEN_DuelIsInitialise_THEN_TheDefenderIsNull() {
		
		assertNull(duelMock.defender);
	}
	
	@Test
	public void WHEN_DuelIsInitialise_THEN_TheAttackerWeaponIsNull() {
		
		assertNull(duelMock.attackerWeapon);
	}
	
	@Test
	public void WHEN_DuelIsProvoked_THEN_TheDefenderIsSet() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		
		assertEquals(defenderSpy, duelMock.defender);
	}
	
	@Test
	public void WHEN_DuelIsProvoked_THEN_TheAttackerWeaponIsSet() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		
		assertEquals(weaponDummy, duelMock.attackerWeapon);
	}
	
	@Test
	public void WHEN_AttackerIsMorePowerfullThanTheDefender_THEN_HeWinsTheFight() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		duelMock.fight(weaponDummy);
		
		assertEquals(attackerStub, duelMock.winner);
	}
	
	@Test
	public void WHEN_DefenderIsMorePowerfullThanTheAttacker_THEN_HeWinsTheFight() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		attackerStub.power = -1;
		duelMock.fight(weaponDummy);
		
		assertEquals(defenderSpy, duelMock.winner);
	}
	
	@Test
	public void WHEN_AttackerPowerIsEqualToTheDefender_THEN_TheAttackerWinsTheFight() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		attackerStub.power = 0;
		duelMock.fight(weaponDummy);
		
		assertEquals(attackerStub, duelMock.winner);
	}
	
	@Test
	public void WHEN_DefenderRefuseTofight_THEN_TheAttackerWinsTheFight() {
		duelMock.provoke(defenderSpy, (IAttack) weaponDummy);
		duelMock.surrender();
		
		assertEquals(attackerStub, duelMock.winner);
	}

}
