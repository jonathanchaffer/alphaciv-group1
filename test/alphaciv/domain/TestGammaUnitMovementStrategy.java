package alphaciv.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestGammaUnitMovementStrategy {

	UnitMovementStrategy movementStrategy;

	@Before
	public void setUp() {
		movementStrategy = new GammaUnitMovementStrategy();
	}

	@Test
	public void testCanMoveUnit() {
		Unit unit = new UnitImpl(GameConstants.ARCHER, Player.RED);
		assertTrue(movementStrategy.canMoveUnit(unit));
	}

	@Test
	public void cannotMoveFortifiedUnit() {
		Unit unit = new UnitImpl(GameConstants.ARCHER, Player.RED);
		((UnitImpl) unit).toggleIsFortified();
		assertFalse(movementStrategy.canMoveUnit(unit));
	}

}
