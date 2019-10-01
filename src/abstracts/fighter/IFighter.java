package abstracts.fighter;

import abstracts.weapon.IWeapon.weaponType;

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

	int getLifePoint();

	int getInitialLifePoint();

	void setLifePoint(int lifePoint);

	int getPower();

	weaponType getWeaponType();

	void destroyWeapon();
}
