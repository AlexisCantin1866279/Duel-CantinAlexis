package concretes.weapon;

import abstracts.weapon.IAttack;
import concretes.strategy.MagicCapacity;

/**
 * Capacite magique offensive
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class FireBall extends MagicCapacity implements IAttack {

	public FireBall(int power) {
		super(power);
	}

}
