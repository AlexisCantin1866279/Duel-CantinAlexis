package abstracts.weapon;

import abstracts.fighter.IFighter;

public interface IWeapon {

	enum attackType {
		PHYSICAL, MAGIC, HEAL, POTION
	}

	enum weaponType {
		ATTACK, PARADE, HEAL
	}

	int getPower();

	weaponType getWeaponType();

	int getCapacityPower(IFighter fighter);

}
