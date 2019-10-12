package concretes.strategy;

import abstracts.fighter.IFighter;
import concretes.weapon.Weapon;

/**
 * Patron de strategie pour calculer la puissance d'une capacite magique
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public abstract class MagicCapacity extends Weapon {

	public MagicCapacity(int power) {
		super(power);
	}

	public static final int MAGIC_EFFECT = 3;

	@Override
	public int getCapacityPower(IFighter fighter) {
		return (fighter.getIntelligence() * this.getPower() / DIVISOR_CAPACITY) * MAGIC_EFFECT;
	}

}
