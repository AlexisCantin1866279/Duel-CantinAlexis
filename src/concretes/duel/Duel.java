package concretes.duel;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;

public class Duel implements IDuel {
	
	public static final int REWARD_DELTA = 1;

	private IFighter attacker;
	private IFighter defender;
	private IAttack attackerWeapon;

	public Duel(IFighter attacker) {
		this.attacker = attacker;
		this.defender = null;
		this.attackerWeapon = null;
	}

	@Override
	public void provoke(IFighter defender, IAttack attackerWeapon) {
		this.defender = defender;
		this.attackerWeapon = attackerWeapon;
		
		this.defender.challenge(this);
	}

	@Override
	public void fight() {
		int attackerPower = this.attacker.getPower(); //avec arme attaque
		int defenderPower = this.defender.getPower(); //avec arme defense ou attaque
		int lostLife;

		if (attackerPower >= defenderPower) {
			lostLife = attackerPower - defenderPower;
			fightConclusion(this.attacker, this.defender, lostLife);
		} else {
			lostLife = defenderPower - attackerPower;
			fightConclusion(this.defender, this.attacker, lostLife);
		}
	}
	
	@Override
	public void surrender() {
		fightConclusion(this.attacker, this.defender, 0);
	}

	private void fightConclusion(IFighter winner, IFighter looser, int lostLife) {
		looser.setLifePoint(looser.getLifePoint() - lostLife);
		looser.setStrength(looser.getStrength() - REWARD_DELTA);
		looser.setDexterity(looser.getDexterity() - REWARD_DELTA);
		looser.setIntelligence(looser.getIntelligence() - REWARD_DELTA);
		looser.setConcentration(looser.getConcentration() - REWARD_DELTA);

		winner.setStrength(winner.getStrength() + REWARD_DELTA);
		winner.setDexterity(winner.getDexterity() + REWARD_DELTA);
		winner.setIntelligence(winner.getIntelligence() + REWARD_DELTA);
		winner.setConcentration(winner.getConcentration() + REWARD_DELTA);
		
		this.defender.challenge(null); //enleve le defi
	}

}
