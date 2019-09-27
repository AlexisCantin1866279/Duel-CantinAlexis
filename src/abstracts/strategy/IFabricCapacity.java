package abstracts.strategy;

import abstracts.weapon.IWeapon.weaponType;

public interface IFabricCapacity {
	ICapacity create(weaponType type);
}
