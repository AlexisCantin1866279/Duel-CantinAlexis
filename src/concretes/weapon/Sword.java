package concretes.weapon;

import abstracts.weapon.IAttack;
import concretes.strategy.PhysicalCapacity;

/**
 * Capacite physique offensive
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class Sword extends PhysicalCapacity implements IAttack {

	public Sword(int power) {
		super(power);
	}
}
