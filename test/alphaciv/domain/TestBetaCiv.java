package alphaciv.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBetaCiv {
	private Game game;

	@Before
	public void setUp() {
		game = new BetaGameFactory().createGame();
	}

	@Test
	public void worldAgesCorrectly() {
		assertEquals(-4000, game.getAge());
		playRounds(39);
		assertEquals(-100, game.getAge());
		playRounds(1);
		assertEquals(-1, game.getAge());
		playRounds(1);
		assertEquals(1, game.getAge());
		playRounds(1);
		assertEquals(50, game.getAge());
		playRounds(34);
		assertEquals(1750, game.getAge());
		playRounds(6);
		assertEquals(1900, game.getAge());
		playRounds(14);
		assertEquals(1970, game.getAge());
		playRounds(1);
		assertEquals(1971, game.getAge());
		playRounds(1);
		assertEquals(1972, game.getAge());
	}

	@Test
	public void redWinsWhenAllCitiesConquered() {
		game.moveUnit(new Position(4, 3), new Position(4, 2));
		game.endOfTurn();
		game.endOfTurn();
		game.moveUnit(new Position(4, 2), new Position(4, 1));
		City c = game.getCityAt(new Position(4, 1));
		assertEquals(Player.RED, c.getOwner());
		assertEquals(Player.RED, game.getWinner());
	}

	@Test
	public void blueWinsWhenAllCitiesConquered() {
		game.endOfTurn();
		game.moveUnit(new Position(3, 2), new Position(2, 1));
		game.endOfTurn();
		game.endOfTurn();
		game.moveUnit(new Position(2, 1), new Position(1, 1));
		City c = game.getCityAt(new Position(1, 1));
		assertEquals(Player.BLUE, c.getOwner());
		assertEquals(Player.BLUE, game.getWinner());
	}

	private void playRounds(int rounds) {
		for (int i = 0; i < rounds; i++) {
			// call endOfTurn twice to play one round, since there are two players
			game.endOfTurn();
			game.endOfTurn();
		}
	}

}
