package abstracts.duel;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;

public interface IDuel {

	void provoke(IFighter defender, IAttack attackerWeapon);

	void fight();

	void surrender();
}
