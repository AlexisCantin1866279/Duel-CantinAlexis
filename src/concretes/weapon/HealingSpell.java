package concretes.weapon;

import abstracts.weapon.IHealing;
import concretes.strategy.HealCapacity;

/**
 * Capacite magique de soin
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class HealingSpell extends HealCapacity implements IHealing {

	public HealingSpell(int power) {
		super(power);
	}

}
