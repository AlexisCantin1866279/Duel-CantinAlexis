package concretes.infirmary;

import abstracts.fighter.IFighter;
import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IHealing;

/**
 * Classe qui permet l'intanciation de l'infirmerie, quiu permet de soigner tous
 * combatants
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class Infirmary implements IInfirmary {

	@Override
	public void nurse(IFighter fighter, IHealing capacity) {

		fighter.haveWeapon(capacity);

		int healValue = fighter.getPower(capacity);

		if (healValue + fighter.getLifePoint() <= fighter.getInitialLifePoint()) {
			fighter.setLifePoint(healValue + fighter.getLifePoint());
		} else {
			fighter.setLifePoint(fighter.getInitialLifePoint());
		}

		fighter.destroyWeapon(capacity);
	}
}
