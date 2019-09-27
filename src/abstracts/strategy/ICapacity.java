package abstracts.strategy;

import abstracts.fighter.IFighter;
import abstracts.weapon.IWeapon;

public interface ICapacity {
	int getPowerCapacity(IFighter fighter, IWeapon weapon);
}
