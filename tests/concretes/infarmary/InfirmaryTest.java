package concretes.infarmary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.infirmary.IInfirmary;
import abstracts.weapon.IHealing;
import concretes.infirmary.Infirmary;
import mocks.FighterStub;
import mocks.HealingSpellStub;

public class InfirmaryTest {

	private FighterStub fighterToHeal;
	private IInfirmary infirmary;
	private IHealing healingSpellStub;

	@Before
	public void initiliseInfirmary() {
		fighterToHeal = new FighterStub();
		infirmary = new Infirmary();
		healingSpellStub = new HealingSpellStub();
	}
	
	@Test
	public void WHEN_TheFighterHaveALittleInjuryGetNurse_THEN_HeGetsAllHisLifePointBack() {
		fighterToHeal.setLifePoint(FighterStub.BASE_HP - FighterStub.HP_TO_HEAL + 1);
		infirmary.nurse(fighterToHeal, healingSpellStub);
		
		assertEquals(FighterStub.BASE_HP, fighterToHeal.getLifePoint());
	}
	
	@Test
	public void WHEN_TheFighterHaveABigInjuryGetNurse_THEN_HeGetsPartOfHisLifePointBack() {
		fighterToHeal.setLifePoint(FighterStub.BASE_HP - FighterStub.HP_TO_HEAL - 1);
		infirmary.nurse(fighterToHeal, healingSpellStub);
		
		assertEquals(FighterStub.BASE_HP - 1, fighterToHeal.getLifePoint());
	}
	
	@Test
	public void WHEN_FighterGoToInfirmary_THEN_HisCapacityIsDetroy() {
		infirmary.nurse(fighterToHeal, healingSpellStub);
		
		assertEquals(true, fighterToHeal.destroy);
	}

}
