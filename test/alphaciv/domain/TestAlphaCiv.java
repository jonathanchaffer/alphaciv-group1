package alphaciv.domain;

import org.junit.*;
import static org.junit.Assert.*;

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
	public void shouldHaveRedCityAt1_1() {
		City c = game.getCityAt(new Position(1, 1));
		assertNotNull("There should be a city at (1,1)", c);
		Player p = c.getOwner();
		assertEquals("City at (1,1) should be owned by red", Player.RED, p);
	}

	@Test
	public void shouldBeRedTurnFirst() {
		assertEquals(Player.RED, game.getPlayerInTurn());
	}

	@Test
	public void shouldHaveOceanAt1_0() {
		Tile t = game.getTileAt(new Position(1, 0));
		assertNotNull("There should be a tile at (1,0)", t);
		String type = t.getTypeString();
		assertEquals("Tile at (1,0) should have type ocean", GameConstants.OCEANS, type);
	}

	@Test
	public void shouldHaveCorrectInitialUnits() {
		Unit u1 = game.getUnitAt(new Position(2, 0));
		assertNotNull("There should be a unit at (2,0)", u1);
		assertEquals("There is an Archer in tile (2,0)", GameConstants.ARCHER, u1.getTypeString());
		assertEquals("Archer should be red", Player.RED, u1.getOwner());
		Unit u2 = game.getUnitAt(new Position(3, 2));
		assertNotNull("There should be a unit at (3,2)", u2);
		assertEquals("There is an legion in tile (3,2)", GameConstants.LEGION, u2.getTypeString());
		assertEquals("Legion should be blue", Player.BLUE, u2.getOwner());
		Unit u3 = game.getUnitAt(new Position(4, 3));
		assertNotNull("There should be a unit at (4,3)", u3);
		assertEquals("There is an settler in tile (4,3)", GameConstants.SETTLER, u3.getTypeString());
		assertEquals("Settler should be red", Player.RED, u3.getOwner());
	}

	@Test
	public void shouldTurnOverToBlueWhenEndOfTurnIsCalled() {
		game.endOfTurn();
		assertEquals(Player.BLUE, game.getPlayerInTurn());
	}

	@Test
	public void shouldTurnOverToRedWhenRoundEnds() {
		game.endOfTurn();
		game.endOfTurn();
		assertEquals(Player.RED, game.getPlayerInTurn());
	}
	
	@Test
	public void shouldStartGameAt4000BC() {
		assertEquals(GameConstants.STARTAGE, game.getAge());
	}
	
	@Test
	public void shouldAge100YearsAfterRound() {
		game.endOfTurn();
		game.endOfTurn();
		assertEquals(GameConstants.STARTAGE + GameConstants.YEARSPERROUND, game.getAge());
		game.endOfTurn();
		game.endOfTurn();
		assertEquals(GameConstants.STARTAGE + 2 * GameConstants.YEARSPERROUND, game.getAge());
	}
	
//	@Test
//	public void unitsCanMove() {
//		Unit u = game.
//	}
//	}

}