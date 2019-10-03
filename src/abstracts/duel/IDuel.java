package abstracts.duel;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IWeapon;

public interface IDuel {

	void provoke(IFighter defender, IAttack attackerWeapon);

	void fight(IWeapon defenderWeapon);

	void surrender();
}
