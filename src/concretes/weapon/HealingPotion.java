package concretes.weapon;

import abstracts.weapon.IHealing;
import concretes.strategy.PotionCapacity;

public class HealingPotion extends PotionCapacity implements IHealing{

	public HealingPotion(int power) {
		super(power);
	}

}
