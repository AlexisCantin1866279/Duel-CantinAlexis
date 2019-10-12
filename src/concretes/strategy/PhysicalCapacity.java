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
	public int getCapacityPower(IFighter fighter) {//MS Attention, on a regroupé Sword et Shield sous cette stratégie parce que le calcul se ressemblait, mais dans les faits, ce n'est pas la même capacité qui est utilisée. Qu'arrivera-t-il si on accepte qu'une capacité ait plus d'une caractéristique?
		return fighter.getStrength() * this.getPower() / DIVISOR_CAPACITY;
	}

}
