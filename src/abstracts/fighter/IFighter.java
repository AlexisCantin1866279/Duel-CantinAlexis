package abstracts.fighter;

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

	void nurse();

	void destroyWeapon();
}
