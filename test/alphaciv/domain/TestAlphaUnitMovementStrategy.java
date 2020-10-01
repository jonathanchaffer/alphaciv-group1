package alphaciv.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestAlphaUnitMovementStrategy {
	UnitMovementStrategy movementStrategy;

	@Before
	public void setUp() {
		movementStrategy = new AlphaUnitMovementStrategy();
	}

	@Test
	public void testCanMoveUnit() {
		Unit unit = new UnitImpl(GameConstants.ARCHER, Player.RED);
		assertTrue(movementStrategy.canMoveUnit(unit));
	}

}
