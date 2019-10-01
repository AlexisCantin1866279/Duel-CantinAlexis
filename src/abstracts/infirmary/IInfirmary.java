package abstracts.infirmary;

import abstracts.fighter.IFighter;
import abstracts.weapon.IHealing;

public interface IInfirmary {
	void nurse(IFighter fighter, IHealing capacity);
}
