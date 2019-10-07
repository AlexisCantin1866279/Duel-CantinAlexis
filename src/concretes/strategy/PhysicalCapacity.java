package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

/**
 * Patron de strategie pour calculer la puissance d'une capacite physique
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public abstract class PhysicalCapacity extends Weapon {

	public PhysicalCapacity(int power) {
		super(power);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getStrength() * this.getPower() / DIVISOR_CAPACITY;
	}

}
