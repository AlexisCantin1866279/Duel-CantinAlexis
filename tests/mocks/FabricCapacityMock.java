package mocks;

import abstracts.strategy.ICapacity;
import abstracts.strategy.IFabricCapacity;
import abstracts.weapon.IWeapon.weaponType;

public class FabricCapacityMock implements IFabricCapacity {

	@Override
	public ICapacity create(weaponType type) {

		ICapacity capacity = null;

		switch (type) {
		case PHYSICAL:
			capacity = new PhysicalCapacitySpy();
			break;
		case MAGIC:
			capacity = new MagicCapacitySpy();
			break;
		case HEAL:
			capacity = new HealCapacitySpy();
			break;
		case POTION:
			capacity = new PotionCapacitySpy();
		}

		return capacity;
	}

}