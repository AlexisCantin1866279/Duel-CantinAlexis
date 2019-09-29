package concretes.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.strategy.ICapacity;
import abstracts.strategy.IFabricCapacity;
import abstracts.weapon.IWeapon;
import abstracts.weapon.IWeapon.attackType;
import mocks.FabricCapacityMock;
import mocks.FighterStub;
import mocks.HealCapacitySpy;
import mocks.MagicCapacitySpy;
import mocks.PhysicalCapacitySpy;
import mocks.PotionCapacitySpy;
import mocks.WeaponStub;

public class CapacityStrategiesTest {

	// tested class
	ICapacity potionCapacity;
	ICapacity physicalCapacity;
	ICapacity magicCapacity;
	ICapacity healCapacity;

	// stub for the tested class
	IFighter fighterStub;
	IWeapon weaponStub;

	// mock to call spy on this class
	IFabricCapacity fabricCapacityMock;

	@Before
	public void initialyseCapacities() {
		potionCapacity = new PotionCapacity();
		physicalCapacity = new PhysicalCapacity();
		magicCapacity = new MagicCapacity();
		healCapacity = new HealCapacity();

		fighterStub = new FighterStub();
		weaponStub = new WeaponStub();

		fabricCapacityMock = new FabricCapacityMock();
	}

	@Test
	public void GIVEN_PotionCapacity_WHEN_PowerCapacityIsAsked_THEN_TheGoodResultIsReturned() {
		int value = potionCapacity.getPowerCapacity(fighterStub, weaponStub);

		final int EXPECTED = fighterStub.getDexterity() * weaponStub.getPower() / 100;
		assertEquals(EXPECTED, value);
	}

	@Test
	public void GIVEN_PhysicalCapacity_WHEN_PowerCapacityIsAsked_THEN_TheGoodResultIsReturned() {
		int value = physicalCapacity.getPowerCapacity(fighterStub, weaponStub);

		final int EXPECTED = fighterStub.getStrength() * weaponStub.getPower() / 100;
		assertEquals(EXPECTED, value);
	}

	@Test
	public void GIVEN_MagicCapacity_WHEN_PowerCapacityIsAsked_THEN_TheGoodResultIsReturned() {
		int value = magicCapacity.getPowerCapacity(fighterStub, weaponStub);

		final int EXPECTED = (fighterStub.getIntelligence() * weaponStub.getPower() / 100) * MagicCapacity.MAGIC_EFFECT;
		assertEquals(EXPECTED, value);
	}

	@Test
	public void GIVEN_HealCapacity_WHEN_PowerCapacityIsAsked_THEN_TheGoodResultIsReturned() {
		int value = healCapacity.getPowerCapacity(fighterStub, weaponStub);

		final int EXPECTED = fighterStub.getIntelligence() * weaponStub.getPower() / 100;
		assertEquals(EXPECTED, value);
	}

	@Test
	public void WHEN_TypeIsPhysical_THEN_TheGoodStrategyIsReturned() {
		ICapacity capacity = fabricCapacityMock.create(attackType.PHYSICAL);
		PhysicalCapacitySpy physicalCapacitySpy = (PhysicalCapacitySpy) capacity;

		assertEquals(true, physicalCapacitySpy.hasBeenCall);

	}

	@Test
	public void WHEN_TypeIsMagic_THEN_TheGoodStrategyIsReturned() {
		ICapacity capacity = fabricCapacityMock.create(attackType.MAGIC);
		MagicCapacitySpy magicCapacitySpy = (MagicCapacitySpy) capacity;

		assertEquals(true, magicCapacitySpy.hasBeenCall);

	}

	@Test
	public void WHEN_TypeIsHeal_THEN_TheGoodStrategyIsReturned() {
		ICapacity capacity = fabricCapacityMock.create(attackType.HEAL);
		HealCapacitySpy healCapacitySpy = (HealCapacitySpy) capacity;

		assertEquals(true, healCapacitySpy.hasBeenCall);

	}

	@Test
	public void WHEN_TypeIsPotion_THEN_TheGoodStrategyIsReturned() {
		ICapacity capacity = fabricCapacityMock.create(attackType.POTION);
		PotionCapacitySpy potionCapacitySpy = (PotionCapacitySpy) capacity;

		assertEquals(true, potionCapacitySpy.hasBeenCall);

	}

}
