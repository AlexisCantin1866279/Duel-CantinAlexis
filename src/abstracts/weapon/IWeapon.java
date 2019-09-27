package abstracts.weapon;

import abstracts.fighter.IFighter;

public interface IWeapon {

	enum weaponType {
		PHYSICAL, MAGIC, HEAL, POTION
	}

	int getPower();
	
	int attack(IFighter fighter);

}
