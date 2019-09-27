package abstracts.weapon;

import abstracts.weapon.IWeapon.weaponType;

public interface IFrabricCapacity {
	ICapacity create(weaponType type);
}
