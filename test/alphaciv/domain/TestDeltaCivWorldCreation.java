package alphaciv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestDeltaCivWorldCreation {
	private Game game;

	@Test
	public void createsDefaultTiles() {
		game = new DeltaGameFactory().createGame();
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(0, 0)).getTypeString());
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(15, 15)).getTypeString());
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(7, 4)).getTypeString());
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(13, 8)).getTypeString());
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(11, 3)).getTypeString());
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(7, 13)).getTypeString());
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1, 3)).getTypeString());
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(8, 9)).getTypeString());
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(1, 11)).getTypeString());
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(9, 11)).getTypeString());
	}

	@Test
	public void createsDefaultCities() {
		game = new DeltaGameFactory().createGame();
		City c1 = game.getCityAt(new Position(8, 12));
		assertNotNull(c1);
		assertEquals(Player.RED, c1.getOwner());

		City c2 = game.getCityAt(new Position(4, 5));
		assertNotNull(c2);
		assertEquals(Player.BLUE, c2.getOwner());

		assertNull(game.getCityAt(new Position(7, 4)));
	}

}
