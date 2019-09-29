package abstracts.strategy;

import abstracts.weapon.IWeapon.attackType;

public interface IFabricCapacity {
	ICapacity create(attackType type);
}
