package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

/**
 * Patron de strategie pour calculer la puissance d'une capacite de remede
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public abstract class PotionCapacity extends Weapon {

	public PotionCapacity(int power) {
		super(power);
	}

	@Override
	public int getCapacityPower(IFighter fighter) {
		return fighter.getDexterity() * this.getPower() / DIVISOR_CAPACITY;
	}

}
