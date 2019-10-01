package concretes.weapon;

import abstracts.weapon.IAttack;
import concretes.strategy.PhysicalCapacity;

public class Sword extends PhysicalCapacity implements IAttack {

	public Sword(int power) {
		super(power);
	}
}
