package concretes.infirmary;

import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IHealing;

public final class Infirmary implements IInfirmary {

	@Override
	public void nurse(IFighter fighter, IHealing capacity) {

		int healValue = fighter.getPower();

		if (healValue + fighter.getLifePoint() <= fighter.getInitialLifePoint()) {
			fighter.setLifePoint(healValue + fighter.getLifePoint());
		} else {
			fighter.setLifePoint(fighter.getInitialLifePoint());
		}
		
		fighter.destroyWeapon();
	}
}
