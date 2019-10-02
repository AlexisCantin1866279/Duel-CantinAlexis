package mocks;

import abstracts.duel.IDuel;
import abstracts.fighter.IFighter;
import abstracts.weapon.IAttack;

public class DuelMock implements IDuel {
	
	public IFighter attacker;
	public IFighter defender;
	public IAttack attackerWeapon;
	
	public IFighter winner;
	
	public DuelMock(IFighter attacker) {
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
			setWinner(this.attacker);
			lostLife = attackerPower - defenderPower;
			fightConclusion(this.attacker, this.defender, lostLife);
		} else {
			setWinner(this.defender);
			lostLife = defenderPower - attackerPower;
			fightConclusion(this.defender, this.attacker, lostLife);
		}
		
	}

	@Override
	public void surrender() {
		setWinner(this.attacker);
		
	}
	
	public void fightConclusion(IFighter winner, IFighter looser, int lostLife) {
		looser.setLifePoint(looser.getLifePoint() - lostLife);
		looser.setStrength(looser.getStrength() - 1);
		looser.setDexterity(looser.getDexterity() - 1);
		looser.setIntelligence(looser.getIntelligence() - 1);
		looser.setConcentration(looser.getConcentration() - 1);

		winner.setStrength(winner.getStrength() + 1);
		winner.setDexterity(winner.getDexterity() + 1);
		winner.setIntelligence(winner.getIntelligence() + 1);
		winner.setConcentration(winner.getConcentration() + 1);
		
		this.defender.challenge(null); //enleve le defi
	}
	
	public void setWinner(IFighter winner) {
		this.winner = winner;
	}

}
