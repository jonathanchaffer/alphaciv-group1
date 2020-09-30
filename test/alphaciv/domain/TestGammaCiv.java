package alphaciv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class TestGammaCiv {
	private Game game;

	@Before
	public void setUp() {
		game = new GammaGameFactory().createGame();
	}

	@Test
	public void settlerPerformsActionandBuildsCity() {
		Unit settler = game.getUnitAt(new Position(4, 3));
		assertNotNull(settler);
		assertEquals(Player.RED, settler.getOwner());
		assertEquals(GameConstants.SETTLER, settler.getTypeString());
		game.performUnitActionAt(new Position(4, 3));
		assertNull(game.getUnitAt(new Position(4, 3)));
		City newCity = game.getCityAt(new Position(4, 3));
		assertNotNull(newCity);
		assertEquals(Player.RED, newCity.getOwner());
		assertEquals(1, newCity.getSize());
	}

	@Test
	public void blueCannotPerformRedUnitAction() {
		game.endOfTurn();
		Unit settler = game.getUnitAt(new Position(4, 3));
		assertNotNull(settler);
		assertEquals(Player.RED, settler.getOwner());
		assertEquals(GameConstants.SETTLER, settler.getTypeString());
		game.performUnitActionAt(new Position(4, 3));
		assertNotNull(game.getUnitAt(new Position(4, 3)));
		assertNull(game.getCityAt(new Position(4, 3)));
	}

}
