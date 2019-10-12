package abstracts.infirmary;

import abstracts.fighter.IFighter;
import abstracts.weapon.IHealing;

/**
 * Interface de l'infirmerie
 * 
 * @author Alexis Cantin
 * @version Octobre 2019
 */
public interface IInfirmary {
	void nurse(IFighter fighter, IHealing capacity);
}
