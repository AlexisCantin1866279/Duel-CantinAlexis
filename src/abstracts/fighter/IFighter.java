package abstracts.fighter;

import abstracts.duel.IDuel;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;

public interface IFighter {

	String getName();

	int getStrength();

	void setStrength(int strength);

	int getDexterity();

	void setDexterity(int dexterity);

	int getIntelligence();

	void setIntelligence(int intelligence);

	int getConcentration();

	void setConcentration(int concentration);

	int getInitialLifePoint();

	int getLifePoint();

	void setLifePoint(int lifePoint);

	int getPower(IWeapon weapon);

	void nurse(IHealing healingCapacity);

	void destroyWeapon(IWeapon weapon);

	void provoke(IFighter defender, IAttack attackerWeapon);

	void challenge(IDuel duelChallenger);

	void hitBack(IAttack defenderWeapon);

	void hitBack(IParade defenderWeapon);

	void surrender();

	void addWeapon(IWeapon weapon);

	void increaseWeaponLimit();
}
