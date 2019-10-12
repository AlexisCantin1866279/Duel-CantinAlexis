package concretes.weapon;

import abstracts.weapon.IHealing;
import concretes.strategy.PotionCapacity;

/**
 * Capacite de remede
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class HealingPotion extends PotionCapacity implements IHealing{

	public HealingPotion(int power) {
		super(power);
	}

}
