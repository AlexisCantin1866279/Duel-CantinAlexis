package concretes.weapon;

import abstracts.weapon.IParade;
import concretes.strategy.PhysicalCapacity;

/**
 * Capacite physique defensive
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public class Shield extends PhysicalCapacity implements IParade {

	public Shield(int power) {
		super(power);
	}

}
