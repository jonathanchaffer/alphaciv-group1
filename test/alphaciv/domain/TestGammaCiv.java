package alphaciv.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
	@Test
	public void unitsShouldNotBeFortifiedByDefault() {
		UnitImpl unit1 = (UnitImpl) game.getUnitAt(new Position(4,3));
		assertNotNull(unit1);
		assertEquals(GameConstants.SETTLER, unit1.getTypeString());
		assertFalse(unit1.isFortified());
		
		UnitImpl unit2 = (UnitImpl) game.getUnitAt(new Position(3,2));
		assertNotNull(unit2);
		assertEquals(GameConstants.LEGION, unit2.getTypeString());
		assertFalse(unit2.isFortified());
		
		UnitImpl unit3 = (UnitImpl) game.getUnitAt(new Position(2,0));
		assertNotNull(unit3);
		assertEquals(GameConstants.ARCHER, unit3.getTypeString());
		assertFalse(unit3.isFortified());
		
	}
	@Test
	public void fortifiedArchersShouldNotMove() {
		UnitImpl unit3 = (UnitImpl) game.getUnitAt(new Position(2,0));
		assertNotNull(unit3);
		assertEquals(GameConstants.ARCHER, unit3.getTypeString());
		assertFalse(unit3.isFortified());
		game.performUnitActionAt(new Position(2,0));
		assertTrue(unit3.isFortified()); 
		assertFalse(game.moveUnit(new Position(2,0), new Position(2,1)));
		assertNull(game.getUnitAt(new Position(2,1))); 
		assertNotNull(game.getUnitAt(new Position(2,0)));
	}

}
