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

	public FireBall(int power) {//MS D'o� vient le FireBall? Dans l'�nonc�, c'est DefensiveSpell et OffensiveSpell???
		super(power);
	}

}
