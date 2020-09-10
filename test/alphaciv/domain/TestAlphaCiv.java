package alphaciv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Skeleton class for AlphaCiv test cases
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class TestAlphaCiv {
	private Game game;

	/** Fixture for alphaciv testing. */
	@Before
	public void setUp() {
		game = new GameImpl();
	}

	@Test
	public void shouldHaveCorrectInitialCities() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);
		assertEquals(Player.RED, c1.getOwner());

		City c2 = game.getCityAt(new Position(4, 1));
		assertNotNull(c2);
		assertEquals(Player.BLUE, c2.getOwner());
	}

	@Test
	public void shouldNotHaveCityAt15_15() {
		City c = game.getCityAt(new Position(15, 15));
		assertNull(c);
	}

	@Test
	public void shouldHaveOceanAt1_0() {
		Tile t = game.getTileAt(new Position(1, 0));
		assertNotNull(t);
		assertEquals(GameConstants.OCEANS, t.getTypeString());
	}

	@Test
	public void shouldHaveHillAt0_1() {
		Tile t = game.getTileAt(new Position(0, 1));
		assertNotNull(t);
		assertEquals(GameConstants.HILLS, t.getTypeString());
	}

	@Test
	public void shouldHaveMountainAt2_2() {
		Tile t = game.getTileAt(new Position(2, 2));
		assertNotNull(t);
		assertEquals(GameConstants.MOUNTAINS, t.getTypeString());
	}

	@Test
	public void shouldHavePlainAt15_15() {
		Tile t = game.getTileAt(new Position(15, 15));
		assertNotNull(t);
		assertEquals(GameConstants.PLAINS, t.getTypeString());
	}

	@Test
	public void shouldHaveCorrectInitialUnits() {
		Unit u1 = game.getUnitAt(new Position(2, 0));
		assertNotNull(u1);
		assertEquals(GameConstants.ARCHER, u1.getTypeString());
		assertEquals(Player.RED, u1.getOwner());

		Unit u2 = game.getUnitAt(new Position(3, 2));
		assertNotNull(u2);
		assertEquals(GameConstants.LEGION, u2.getTypeString());
		assertEquals(Player.BLUE, u2.getOwner());

		Unit u3 = game.getUnitAt(new Position(4, 3));
		assertNotNull(u3);
		assertEquals(GameConstants.SETTLER, u3.getTypeString());
		assertEquals(Player.RED, u3.getOwner());
	}

	@Test
	public void shouldNotHaveUnitAt15_15() {
		Unit u = game.getUnitAt(new Position(15, 15));
		assertNull(u);
	}

	@Test
	public void shouldBeRedTurnFirst() {
		assertEquals(Player.RED, game.getPlayerInTurn());
	}

	@Test
	public void shouldTurnOverToBlueWhenEndOfTurnIsCalled() {
		game.endOfTurn();
		assertEquals(Player.BLUE, game.getPlayerInTurn());
	}

	@Test
	public void shouldTurnOverToRedWhenRoundEnds() {
		playRounds(1);
		assertEquals(Player.RED, game.getPlayerInTurn());
	}

	@Test
	public void shouldStartGameAt4000BC() {
		assertEquals(GameConstants.STARTAGE, game.getAge());
	}

	@Test
	public void shouldAge100YearsAfterRound() {
		playRounds(1);
		assertEquals(GameConstants.STARTAGE + GameConstants.YEARSPERROUND, game.getAge());
		playRounds(1);
		assertEquals(GameConstants.STARTAGE + 2 * GameConstants.YEARSPERROUND, game.getAge());
	}

	@Test
	public void redShouldWinAt3000BC() {
		for (int i = 0; i < 10; i++) {
			assertNull(game.getWinner());
			playRounds(1);
		}
		assertEquals(-3000, game.getAge());
		assertEquals(Player.RED, game.getWinner());
	}

	@Test
	public void testValidMoves() {
		assertTrue(game.moveUnit(new Position(2, 0), new Position(2, 1)));
		Unit u1 = game.getUnitAt(new Position(2, 1));
		assertNotNull(u1);
		assertEquals(GameConstants.ARCHER, u1.getTypeString());
		assertEquals(Player.RED, u1.getOwner());
		assertNull(game.getUnitAt(new Position(2, 0)));
		game.endOfTurn();

		assertTrue(game.moveUnit(new Position(3, 2), new Position(4, 1)));
		Unit u2 = game.getUnitAt(new Position(4, 1));
		assertNotNull(u2);
		assertEquals(GameConstants.LEGION, u2.getTypeString());
		assertEquals(Player.BLUE, u2.getOwner());
		assertNull(game.getUnitAt(new Position(3, 2)));
		game.endOfTurn();

		assertTrue(game.moveUnit(new Position(4, 3), new Position(5, 3)));
		Unit u3 = game.getUnitAt(new Position(5, 3));
		assertNotNull(u3);
		assertEquals(GameConstants.SETTLER, u3.getTypeString());
		assertEquals(Player.RED, u3.getOwner());
		assertNull(game.getUnitAt(new Position(4, 3)));
		game.endOfTurn();
	}

	@Test
	public void cannotMoveIntoMountainsOrOceans() {
		assertFalse(game.moveUnit(new Position(2, 0), new Position(1, 0)));
		game.endOfTurn();
		assertFalse(game.moveUnit(new Position(3, 2), new Position(2, 2)));
	}

	@Test
	public void canOnlyMoveUnitsWhenItsOwnersTurn() {
		assertFalse(game.moveUnit(new Position(3, 2), new Position(4, 1)));
		Unit u2 = game.getUnitAt(new Position(4, 1));
		assertNull(u2);
		game.endOfTurn();
		assertFalse(game.moveUnit(new Position(2, 0), new Position(2, 1)));
		Unit u1 = game.getUnitAt(new Position(2, 1));
		assertNull(u1);
	}

	@Test
	public void attackWorks() {
		game.moveUnit(new Position(4, 3), new Position(3, 2));
		assertNull(game.getUnitAt(new Position(4, 3)));
		Unit newUnit = game.getUnitAt(new Position(3, 2));
		assertNotNull(newUnit);
		assertEquals(Player.RED, newUnit.getOwner());
		assertEquals(GameConstants.SETTLER, newUnit.getTypeString());
	}

	@Test
	public void cityProductionIsArcherByDefault() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);
		assertEquals(GameConstants.ARCHER, c1.getProduction());
	}

	@Test
	public void citiesProduceArcherAfterTwoRounds() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);
		playRounds(2);
		Unit newUnit = game.getUnitAt(new Position(1, 1));
		assertNotNull(newUnit);
		assertEquals(GameConstants.ARCHER, newUnit.getTypeString());
		assertEquals(Player.RED, newUnit.getOwner());
	}

	@Test
	public void unitsSpawnedClockwiseAroundCity() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);

		playRounds(4);
		Unit u1 = game.getUnitAt(new Position(0, 1));
		assertNotNull(u1);
		assertEquals(GameConstants.ARCHER, u1.getTypeString());
		assertNull(game.getUnitAt(new Position(0, 2)));

		playRounds(1);
		Unit u2 = game.getUnitAt(new Position(0, 2));
		assertNotNull(u2);
		assertEquals(GameConstants.ARCHER, u2.getTypeString());
		assertNull(game.getUnitAt(new Position(1, 2)));

		playRounds(2);
		Unit u3 = game.getUnitAt(new Position(1, 2));
		assertNotNull(u3);
		assertEquals(GameConstants.ARCHER, u3.getTypeString());
		assertNull(game.getUnitAt(new Position(2, 1)));

		playRounds(2);
		Unit u4 = game.getUnitAt(new Position(2, 1));
		assertNotNull(u4);
		assertEquals(GameConstants.ARCHER, u4.getTypeString());
		assertNull(game.getUnitAt(new Position(0, 0)));

		playRounds(1);
		Unit u5 = game.getUnitAt(new Position(0, 0));
		assertNotNull(u5);
		assertEquals(GameConstants.ARCHER, u5.getTypeString());
	}

	@Test
	public void populationOfCityShouldAlwaysBe1() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);
		assertEquals(1, c1.getSize());
		playRounds(5);
		assertEquals(1, c1.getSize());
	}

	@Test
	public void canChangeProductionTypeForCity() {
		City c1 = game.getCityAt(new Position(1, 1));
		assertNotNull(c1);
		assertEquals(GameConstants.ARCHER, c1.getProduction());
		game.changeProductionInCityAt(new Position(1, 1), GameConstants.SETTLER);
		assertEquals(GameConstants.SETTLER, c1.getProduction());
		game.changeProductionInCityAt(new Position(1, 1), GameConstants.LEGION);
		assertEquals(GameConstants.LEGION, c1.getProduction());
	}

	@Test
	public void cannotChangeProductionWhenNotInTurn() {
		City c1 = game.getCityAt(new Position(4, 1));
		assertNotNull(c1);
		assertEquals(GameConstants.ARCHER, c1.getProduction());
		game.changeProductionInCityAt(new Position(4, 1), GameConstants.SETTLER);
		assertEquals(GameConstants.ARCHER, c1.getProduction());
	}

	private void playRounds(int rounds) {
		for (int i = 0; i < rounds * 2; i++) {
			game.endOfTurn();
		}
	}

}