package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

/**
 * Patron de strategie pour calculer la puissance d'une capacite de soin magique
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public abstract class HealCapacity extends Weapon {

	public HealCapacity(int power) {
		super(power);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getIntelligence() * this.getPower() / DIVISOR_CAPACITY;
	}

}
