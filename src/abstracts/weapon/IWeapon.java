package abstracts.weapon;

public interface IWeapon {
	enum weaponType {
		PHYSICAL,
		MAGIC,
		HEAL,
		POTION
	}
	
	int getPower();
}
