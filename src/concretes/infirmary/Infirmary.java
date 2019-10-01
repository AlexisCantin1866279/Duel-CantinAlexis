package concretes.infirmary;

import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;

public final class Infirmary implements IInfirmary {

	public void nurse(IFighter fighter) {
		/*if (fighter.getWeaponType() != weaponType.HEAL)
			throw new HealTypeException();*/

		int healValue = fighter.getPower(); // changer le nom ?

		if (healValue + fighter.getLifePoint() <= fighter.getInitialLifePoint()) {
			fighter.setLifePoint(healValue + fighter.getLifePoint());
		} else {
			fighter.setLifePoint(fighter.getInitialLifePoint());
		}
		
		fighter.destroyWeapon();
	}
}