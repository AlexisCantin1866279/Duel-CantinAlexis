package concretes.weapon;

import abstracts.weapon.IAttack;
import concretes.strategy.MagicCapacity;

public class FireBall extends MagicCapacity implements IAttack {

	public FireBall(int power) { 																		
		super(power);
	}

}
