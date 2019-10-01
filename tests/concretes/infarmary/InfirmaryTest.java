package concretes.infarmary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abstracts.infirmary.IInfirmary;
import concretes.infirmary.Infirmary;
import mocks.FighterStub;

public class InfirmaryTest {

	private FighterStub fighterToHeal;
	private IInfirmary infirmary;

	@Before
	public void initiliseInfirmary() {
		fighterToHeal = new FighterStub();
		infirmary = new Infirmary();
	}

//	@Test(expected = HealTypeException.class)
//	public void WHEN_TheFighterHaveNoHealWeaponType() {
//		fighterToHeal.type = weaponType.ATTACK;
//		infirmary.nurse(fighterToHeal);
//	}
	
	@Test
	public void WHEN_TheFighterHaveALittleInjuryGetNurse_THEN_HeGetsAllHisLifePointBack() {
		fighterToHeal.setLifePoint(FighterStub.BASE_HP - FighterStub.HP_TO_HEAL + 1);
		infirmary.nurse(fighterToHeal);
		
		assertEquals(FighterStub.BASE_HP, fighterToHeal.getLifePoint());
	}
	
	@Test
	public void WHEN_TheFighterHaveABigInjuryGetNurse_THEN_HeGetsPartOfHisLifePointBack() {
		fighterToHeal.setLifePoint(FighterStub.BASE_HP - FighterStub.HP_TO_HEAL - 1);
		infirmary.nurse(fighterToHeal);
		
		assertEquals(FighterStub.BASE_HP - 1, fighterToHeal.getLifePoint());
	}
	
	@Test
	public void WHEN_FighterGoToInfirmary_THEN_HisCapacityIsDetroy() {
		infirmary.nurse(fighterToHeal);
		
		assertEquals(true, fighterToHeal.destroy);
	}

}
