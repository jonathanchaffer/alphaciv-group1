package alphaciv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

	@Test
	public void createsDefaultUnits() {
		game = new DeltaGameFactory().createGame();

		Unit u1 = game.getUnitAt(new Position(3, 8));
		assertNotNull(u1);
		assertEquals(Player.BLUE, u1.getOwner());
		assertEquals(GameConstants.ARCHER, u1.getTypeString());

		Unit u2 = game.getUnitAt(new Position(4, 4));
		assertNotNull(u2);
		assertEquals(Player.BLUE, u2.getOwner());
		assertEquals(GameConstants.LEGION, u2.getTypeString());

		Unit u3 = game.getUnitAt(new Position(5, 5));
		assertNotNull(u3);
		assertEquals(Player.BLUE, u3.getOwner());
		assertEquals(GameConstants.SETTLER, u3.getTypeString());

		assertNull(game.getUnitAt(new Position(14, 2)));
	}

}
