package alphaciv.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGammaUnitActionStrategy {
	UnitActionStrategy actionStrategy;
	
	@Before 
	public void setUp() {
		actionStrategy = new GammaUnitActionStrategy();
	}
	@Test
	public void settlerCanPerformAction() {
		City[][] cities = new CityImpl[1][1];
		Unit[][] units = new UnitImpl[][] {{new UnitImpl(GameConstants.SETTLER, Player.BLUE)}};
		actionStrategy.performUnitAction(new Position(0,0), new UnitActionRequirementsImpl(cities, units));
		assertNull(units[0][0]);
		assertNotNull(cities[0][0]);
	}
	@Test
	public void archerCanPerformAction() {
		City[][] cities = new CityImpl[1][1];
		Unit[][] units = new UnitImpl[][] {{new UnitImpl(GameConstants.ARCHER, Player.BLUE)}};
		actionStrategy.performUnitAction(new Position(0,0), new UnitActionRequirementsImpl(cities, units));
		assertNotNull(units[0][0]);
		assertTrue(((UnitImpl) units[0][0]).isFortified());
	}

}
