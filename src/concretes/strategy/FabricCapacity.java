package concretes.strategy;

import abstracts.strategy.ICapacity;
import abstracts.strategy.IFabricCapacity;
import abstracts.weapon.IWeapon.attackType;

public class FabricCapacity implements IFabricCapacity {

	@Override
	public ICapacity create(attackType type) {

		ICapacity capacity = null;

		switch (type) {
		case PHYSICAL:
			capacity = new PhysicalCapacity();
			break;
		case MAGIC:
			capacity = new MagicCapacity();
			break;
		case HEAL:
			capacity = new HealCapacity();
			break;
		case POTION:
			capacity = new PotionCapacity();
		}

		return capacity;
	}

}
