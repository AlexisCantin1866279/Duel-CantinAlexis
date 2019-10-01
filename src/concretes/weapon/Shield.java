package concretes.weapon;

import abstracts.weapon.IParade;
import concretes.strategy.PhysicalCapacity;

public class Shield extends PhysicalCapacity implements IParade {

	public Shield(int power) {
		super(power);
	}

}
