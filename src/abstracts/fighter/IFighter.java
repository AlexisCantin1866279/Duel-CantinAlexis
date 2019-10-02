package abstracts.fighter;

import abstracts.duel.IDuel;
import abstracts.weapon.IAttack;

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

	int getPower();

	void nurse();

	void destroyWeapon();

	void provoke(IFighter defender, IAttack attackerWeapon);

	void challenge(IDuel duelChallenger);

	void hitBack();

	void surrender();
}
