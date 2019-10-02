package concretes.duel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mocks.DuelMock;
import mocks.FighterSpy;
import mocks.FighterStub;
import mocks.SwordStub;

public class DuelTest {
	
	private DuelMock duel;
	private FighterStub attackerStub;
	private FighterSpy defenderSpy;
	private SwordStub swordStub;
	
	@Before
	public void prepareDuel() {
		attackerStub = new FighterStub();
		defenderSpy = new FighterSpy();
		swordStub = new SwordStub();
		duel = new DuelMock(attackerStub);
		
	}

	@Test
	public void WHEN_DuelIsInitialise_THEN_TheAttackerIsSet() {
		
		assertEquals(attackerStub, duel.attacker);
	}
	
	@Test
	public void WHEN_DuelIsInitialise_THEN_TheDefenderIsNull() {
		
		assertNull(duel.defender);
	}
	
	@Test
	public void WHEN_DuelIsInitialise_THEN_TheAttackerWeaponIsNull() {
		
		assertNull(duel.attackerWeapon);
	}
	
	@Test
	public void WHEN_DuelIsProvoked_THEN_TheDefenderIsSet() {
		duel.provoke(defenderSpy, swordStub);
		
		assertEquals(defenderSpy, duel.defender);
	}
	
	@Test
	public void WHEN_DuelIsProvoked_THEN_TheAttackerWeaponIsSet() {
		duel.provoke(defenderSpy, swordStub);
		
		assertEquals(swordStub, duel.attackerWeapon);
	}
	
	@Test
	public void WHEN_AttackerIsMorePowerfullThanTheDefender_THEN_HeWinsTheFight() {
		duel.provoke(defenderSpy, swordStub);
		duel.fight();
		
		assertEquals(attackerStub, duel.winner);
	}
	
	@Test
	public void WHEN_DefenderIsMorePowerfullThanTheAttacker_THEN_HeWinsTheFight() {
		duel.provoke(defenderSpy, swordStub);
		attackerStub.power = -1;
		duel.fight();
		
		assertEquals(defenderSpy, duel.winner);
	}
	
	@Test
	public void WHEN_AttackerPowerIsEqualToTheDefender_THEN_TheAttackerWinsTheFight() {
		duel.provoke(defenderSpy, swordStub);
		attackerStub.power = 0;
		duel.fight();
		
		assertEquals(attackerStub, duel.winner);
	}
	
	@Test
	public void WHEN_DefenderRefuseTofight_THEN_TheAttackerWinsTheFight() {
		duel.provoke(defenderSpy, swordStub);
		duel.surrender();
		
		assertEquals(attackerStub, duel.winner);
	}

}
