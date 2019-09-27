package mocks;

import abstracts.fighter.IFighter;
import abstracts.strategy.ICapacity;
import abstracts.weapon.IWeapon;

public class HealCapacitySpy implements ICapacity {

	public boolean hasBeenCall = false;

	public HealCapacitySpy() {
		this.hasBeenCall = true;
	}

	@Override
	public int getPowerCapacity(IFighter fighter, IWeapon weapon) {
		// TODO Auto-generated method stub
		return 0;
	}

}
