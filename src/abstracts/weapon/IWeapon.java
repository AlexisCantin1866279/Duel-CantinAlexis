package abstracts.weapon;

import abstracts.fighter.IFighter;

public interface IWeapon {

	int getPower();

	int getCapacityPower(IFighter fighter);

}
