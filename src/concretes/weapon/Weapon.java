package concretes.weapon;

import abstracts.weapon.IWeapon;

public abstract class Weapon implements IWeapon {
	
	public static final int MIN_POWER = 20;
	public static final int MAX_POWER = 100;
	
	private String name;
	private int power;
	private weaponType type;
	
	public Weapon(String name, int power, weaponType type) {
		this.name = name;
		this.power = power;
		this.type = type;
	}
	
	
}
