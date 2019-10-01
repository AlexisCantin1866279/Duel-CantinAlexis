package concretes.weapon;

import abstracts.weapon.IHealing;
import concretes.strategy.HealCapacity;

public class HealingSpell extends HealCapacity implements IHealing {

	public HealingSpell(int power) {
		super(power);
	}

}
