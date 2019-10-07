package abstracts.weapon;

import abstracts.fighter.IFighter;

/**
 * Interface de toute capacite
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public interface IWeapon {

	int getPower();

	int getCapacityPower(IFighter fighter);

}
