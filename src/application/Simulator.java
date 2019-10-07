package application;

import java.util.ArrayList;
import java.util.List;

import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;
import abstracts.weapon.IHealing;
import abstracts.weapon.IParade;
import abstracts.weapon.IWeapon;
import concretes.fighter.Athlete;
import concretes.fighter.Warrior;
import concretes.fighter.Wizard;
import concretes.weapon.FireBall;
import concretes.weapon.HealingPotion;
import concretes.weapon.HealingSpell;
import concretes.weapon.Shield;
import concretes.weapon.Sword;
import exceptions.fighter.CapacityExistenceException;
import exceptions.fighter.IllegalFightException;
import exceptions.fighter.ToManyWeaponException;

public class Simulator {

	public static void main(String[] args) {

		IAttack sword = new Sword(30);
		IParade shield = new Shield(30);
		IAttack fireBall = new FireBall(30);
		IHealing healingPotion = new HealingPotion(30);
		IHealing healingSpell = new HealingSpell(30);

		List<IWeapon> list = new ArrayList<IWeapon>();

		list.add(sword);
		list.add(shield);
		IFighter warrior = new Warrior("Jean-Rene", 40, 30, 20, 10, list);

		list.removeAll(list);
		list.add(sword);
		list.add(healingPotion);
		IFighter athlete = new Athlete("Jean-Pascal", 20, 20, 20, 20, list);

		list.removeAll(list);
		list.add(fireBall);
		list.add(healingSpell);
		IFighter wizard = new Wizard("Jean-Claude", 5, 5, 25, 25, list);

		// combat warrior vs wizard
		warrior.provoke(wizard, sword);
		displayBeforeFight(warrior, wizard);
		displayFight(warrior, sword, wizard, fireBall);
		wizard.hitBack(fireBall);
		displayAfterFight(warrior, wizard);

		// combat warrior vs athlete
		athlete.provoke(warrior, sword);
		displayBeforeFight(athlete, warrior);
		displayFight(athlete, sword, warrior, shield);
		warrior.hitBack(shield);
		displayAfterFight(athlete, warrior);

		// combat wizard vs athlete
		athlete.provoke(wizard, sword);
		displayBeforeFight(athlete, wizard);
		displayFight(athlete, sword, wizard, fireBall);
		wizard.hitBack(fireBall);
		displayAfterFight(athlete, wizard);

		// atlhete va a l'infirmerie
		displayBeforeInfirmary(athlete);
		athlete.nurse(healingPotion);
		displayNursingInfirmary(athlete, healingPotion);
		displayAfterInfirmary(athlete);

		// wizard abandonne contre warrior
		warrior.provoke(wizard, sword);
		displayBeforeFight(warrior, wizard);
		wizard.surrender();
		displaySurrender(warrior, wizard);

		// wizard va a l'infirmerie
		displayBeforeInfirmary(wizard);
		wizard.nurse(healingSpell);
		displayNursingInfirmary(wizard, healingSpell);
		displayAfterInfirmary(wizard);

		// warrior peut ajouter une arme a sa collection
		warrior.addWeapon(healingSpell);

		// warrior va a l'infirmerie
		displayBeforeInfirmary(warrior);
		warrior.nurse(healingSpell);
		displayNursingInfirmary(warrior, healingSpell);
		displayAfterInfirmary(warrior);

		// Le sorcier ne peut pas faire un duel tt seul!
		try {
			wizard.hitBack(fireBall);
		} catch (IllegalFightException e) {
			System.out.println("Il n'y a pas de duel, le sorcier a frapper dans le vide!!");
			System.out.println("------------------------------------\n");
		}

		// L'athlete ne peut pas retourner a l'infirmerie
		try {
			athlete.nurse(healingPotion);
		} catch (CapacityExistenceException e) {
			System.out.println("l'athlete ne possede plus sa capacite de soin!");
			System.out.println("------------------------------------\n");
		}

		// le fighter ne peut pas utiliser une arme qu'il ne possede pas
		try {
			athlete.nurse(healingSpell);
		} catch (CapacityExistenceException e) {
			System.out.println("l'athlete n'a jamais posseder cette arme!");
			System.out.println("------------------------------------\n");
		}
		
		// Athlete veut ajouter une capacite, mais n'a jamais gagner de combat
		try {
			athlete.addWeapon(fireBall);
		} catch (ToManyWeaponException e) {
			System.out.println("l'athlete n'a jamais gagner, il ne peut pas ajouter une arme");
			System.out.println("------------------------------------\n");
		}

	}

	private static void displayBeforeFight(IFighter attacker, IFighter defender) {
		System.out.println("Combat entre " + attacker.getName() + " et " + defender.getName());

		System.out.println("\nCapacite de l'attaquant :\nPuissance\t: " + attacker.getStrength() + "\nDexterite\t: "
				+ attacker.getDexterity() + "\nIntelligence\t: " + attacker.getIntelligence() + "\nConcentration\t: "
				+ attacker.getConcentration() + "\nPointDeVie\t: " + attacker.getLifePoint());

		System.out.println("\nCapacite du defenseur :\nPuissance\t: " + defender.getStrength() + "\nDexterite\t: "
				+ defender.getDexterity() + "\nIntelligence\t: " + defender.getIntelligence() + "\nConcentration\t: "
				+ defender.getConcentration() + "\nPointDeVie\t: " + defender.getLifePoint());
	}

	private static void displayFight(IFighter attacker, IAttack attackerWeapon, IFighter defender,
			IWeapon defenderWeapon) {
		System.out.println("\nLe Duel a commence!\n");
		System.out.println("Puissance de l'attaquant: " + attacker.getPower(attackerWeapon));
		System.out.println("Puissance du defenseur\t: " + defender.getPower(defenderWeapon));
	}

	private static void displayAfterFight(IFighter attacker, IFighter defender) {
		System.out.println("\nResultat du combat entre " + attacker.getName() + " et " + defender.getName());

		System.out.println("\nCapacite de l'attaquant :\nPuissance\t: " + attacker.getStrength() + "\nDexterite\t: "
				+ attacker.getDexterity() + "\nIntelligence\t: " + attacker.getIntelligence() + "\nConcentration\t: "
				+ attacker.getConcentration() + "\nPointDeVie\t: " + attacker.getLifePoint());

		System.out.println("\nCapacite du defenseur :\nPuissance\t: " + defender.getStrength() + "\nDexterite\t: "
				+ defender.getDexterity() + "\nIntelligence\t: " + defender.getIntelligence() + "\nConcentration\t: "
				+ defender.getConcentration() + "\nPointDeVie\t: " + defender.getLifePoint());
		System.out.println("------------------------------------\n");
	}

	private static void displayBeforeInfirmary(IFighter fighter) {
		System.out.println("Le combatant " + fighter.getName() + " va a l'infirmerie\n");
		System.out.println("Il a " + fighter.getLifePoint() + " points de vies");
	}

	private static void displayNursingInfirmary(IFighter fighter, IHealing healingCapacity) {
		System.out.println("Le pouvoir de sa capacite de soin et de : " + fighter.getPower(healingCapacity));
	}

	private static void displayAfterInfirmary(IFighter fighter) {
		System.out.println("C'est points de vie ont augmente jusqu'a " + fighter.getLifePoint());
		System.out.println("------------------------------------\n");
	}

	private static void displaySurrender(IFighter attacker, IFighter defender) {
		System.out.println("\n" + defender.getName() + " a abandonne le combat!");

		System.out.println("\nCapacite de l'attaquant :\nPuissance\t: " + attacker.getStrength() + "\nDexterite\t: "
				+ attacker.getDexterity() + "\nIntelligence\t: " + attacker.getIntelligence() + "\nConcentration\t: "
				+ attacker.getConcentration() + "\nPointDeVie\t: " + attacker.getLifePoint());

		System.out.println("\nCapacite du defenseur :\nPuissance\t: " + defender.getStrength() + "\nDexterite\t: "
				+ defender.getDexterity() + "\nIntelligence\t: " + defender.getIntelligence() + "\nConcentration\t: "
				+ defender.getConcentration() + "\nPointDeVie\t: " + defender.getLifePoint());
		System.out.println("------------------------------------\n");
	}

}
